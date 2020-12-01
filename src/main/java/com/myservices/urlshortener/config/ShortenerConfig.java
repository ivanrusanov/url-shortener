package com.myservices.urlshortener.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "shortener")
public class ShortenerConfig {
    /**
     * Host name which would be used in short url
     */
    private String host;

    /**
     * Number of symbols after "/" in short URL
     */
    private int pathLength;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPathLength() {
        return pathLength;
    }

    public void setPathLength(int pathLength) {
        this.pathLength = pathLength;
    }
}
