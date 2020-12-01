package com.myservices.urlshortener.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class LinkIsNotActiveException extends ResponseStatusException {

    public LinkIsNotActiveException() {
        super(HttpStatus.BAD_REQUEST, "Link is not active!");
    }
}
