package com.myservices.urlshortener.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myservices.urlshortener.dto.Link;
import com.myservices.urlshortener.entities.RawLink;
import com.myservices.urlshortener.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LinkController {
    private final LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public String addLink(@RequestBody String json) throws JsonProcessingException {
        RawLink rawLink = new ObjectMapper().readValue(json, RawLink.class);
        Link link = linkService.addLink(rawLink);
        return link.getShortUrl();
    }

    @GetMapping(value = "/{uid}")
    public ModelAndView redirect(@PathVariable String uid, ModelMap modelMap) {
        modelMap.addAttribute("attribute", "redirectWithRedirectPrefix");
        return new ModelAndView("redirect:" + linkService.getRedirectUrl(uid));
    }
}
