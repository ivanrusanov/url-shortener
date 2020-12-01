package com.myservices.urlshortener.dto;

public class LinkDto {
    private String url;
    private boolean unique;

    public String getUrl() {
        return url;
    }

    public boolean isUnique() {
        return unique;
    }
}
