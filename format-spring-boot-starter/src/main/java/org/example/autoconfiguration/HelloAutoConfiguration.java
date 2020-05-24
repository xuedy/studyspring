package org.example.autoconfiguration;

import org.example.FormatTemplate;
import org.example.format.FormatProcessor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Administrator
 * @className HelloAutoConfiguration
 * @description TODO
 * @date {DATE}{TIME}
 */
@Import(FormatAutoConfiguration.class)
@EnableConfigurationProperties(HelloProperties.class)
@Configuration
public class HelloAutoConfiguration {
    @Bean
    public FormatTemplate formatTemplate(FormatProcessor formatProcessor,HelloProperties helloProperties){
        return new FormatTemplate(formatProcessor,helloProperties);

    }
}
