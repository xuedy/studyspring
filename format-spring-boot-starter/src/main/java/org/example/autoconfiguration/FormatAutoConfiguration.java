package org.example.autoconfiguration;

import org.example.format.FormatProcessor;
import org.example.format.JsonFormatProcessor;
import org.example.format.StringFormatProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author Administrator
 * @className FormatAutoConfiguration
 * @description TODO
 * @date {DATE}{TIME}
 */
@Configuration
public class FormatAutoConfiguration {

    @Bean
    @Primary
    @ConditionalOnMissingClass("com.alibaba.fastjson.JSON")
    public FormatProcessor stringFormat(){
        return  new StringFormatProcessor();
    }

    @Bean
    @ConditionalOnClass(name= "com.alibaba.fastjson.JSON")
    public  FormatProcessor jsonFormat(){
        return new JsonFormatProcessor();
    }
}
