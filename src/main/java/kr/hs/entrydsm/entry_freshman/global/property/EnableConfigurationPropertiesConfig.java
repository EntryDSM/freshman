package kr.hs.entrydsm.entry_freshman.global.property;

import kr.hs.entrydsm.entry_freshman.global.security.jwt.JwtProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(value = {JwtProperty.class})
@Configuration
public class EnableConfigurationPropertiesConfig {
}
