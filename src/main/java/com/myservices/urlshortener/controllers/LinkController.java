package com.myservices.urlshortener.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myservices.urlshortener.entities.RawLink;
import com.myservices.urlshortener.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkController {
    private final LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public void addLink(@RequestBody String json) throws JsonProcessingException {
        RawLink rawLink = new ObjectMapper().readValue(json, RawLink.class);
        linkService.addLink(rawLink);
    }
}
