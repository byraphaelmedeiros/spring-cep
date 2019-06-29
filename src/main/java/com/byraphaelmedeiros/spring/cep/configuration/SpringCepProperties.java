package com.byraphaelmedeiros.spring.cep.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Raphael Medeiros (raphael.medeiros@gmail.com)
 * @since 29/06/2019
 */
@Component
@ConfigurationProperties(prefix = "com.byraphaelmedeiros.spring.cep")
public class SpringCepProperties {

    // url
    private String[] url;

    public String[] getUrl() {
        return url;
    }

    public void setUrl(String[] url) {
        this.url = url;
    }
}
