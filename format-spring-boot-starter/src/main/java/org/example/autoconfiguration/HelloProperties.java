package org.example.autoconfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author Administrator
 * @className HelloProperties
 * @description TODO
 * @date {DATE}{TIME}
 */
@ConfigurationProperties(prefix = HelloProperties.DEFAULT_PREFIX)
public class HelloProperties {
    public static final String DEFAULT_PREFIX="xuedy.hello.format";
    private Map<String,Object> info;


    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }
}
