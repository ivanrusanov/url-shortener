package com.myservices.urlshortener.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class LinkNotFound extends ResponseStatusException {

    public LinkNotFound() {
        super(HttpStatus.NOT_FOUND, "Link not found");
    }
}
