package com.myservices.urlshortener.service;

import com.myservices.urlshortener.model.Click;
import com.myservices.urlshortener.model.Link;
import com.myservices.urlshortener.repository.ClickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClickService {

    private final ClickRepository clickRepository;

    @Autowired
    public ClickService(ClickRepository clickRepository) {
        this.clickRepository = clickRepository;
    }

    public void saveClick(Link link, String userAgent) {
        Click click = new Click(LocalDateTime.now(), link, userAgent);
        clickRepository.saveAndFlush(click);
    }
}
