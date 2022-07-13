package kr.hs.entrydsm.freshman.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kr.hs.entrydsm.freshman.global.security.auth.AuthDetailsService;
import kr.hs.entrydsm.freshman.global.security.exception.ExpiredJwtException;
import kr.hs.entrydsm.freshman.global.security.exception.InvalidJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    private final JwtProperty jwtProperty;
    private final AuthDetailsService authDetailsService;

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(AUTHORIZATION_HEADER);
        if (bearer != null && bearer.length() > 7 && bearer.startsWith(BEARER_PREFIX)) {
            return bearer.substring(7);
        }
        return null;
    }

    public String generateToken(String id) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperty.getSecretKey())
                .setSubject(id)
                .setIssuedAt(new Date())
                .setExpiration(getAccessExp())
                .compact();
    }

    private Date getAccessExp() {
        return new Date(System.currentTimeMillis() + jwtProperty.getAccessExp() * 1000);
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailsService
                .loadUserByUsername(getTokenSubject(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String parseToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith(BEARER_PREFIX))
            return bearerToken.replace(BEARER_PREFIX, "");
        return null;
    }

    private Claims getTokenBody(String token) {
        try {
            return Jwts.parser().setSigningKey(jwtProperty.getSecretKey())
                    .parseClaimsJws(token).getBody();
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            throw ExpiredJwtException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidJwtException.EXCEPTION;
        }
    }

    private String getTokenSubject(String token) {
        return getTokenBody(token).getSubject();
    }
}
