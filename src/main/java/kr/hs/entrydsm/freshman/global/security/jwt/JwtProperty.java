package kr.hs.entrydsm.freshman.global.security.jwt;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Base64;

@Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
public class JwtProperty {

    private final String secretKey;
    private final Long accessExp;

    public JwtProperty(String secretKey, Long accessExp) {
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        this.accessExp = accessExp;
    }
}
