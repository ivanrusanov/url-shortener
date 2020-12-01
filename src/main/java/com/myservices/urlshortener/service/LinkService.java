package com.myservices.urlshortener.service;

import com.myservices.urlshortener.exception.LinkIsNotActiveException;
import com.myservices.urlshortener.exception.LinkNotFound;
import com.myservices.urlshortener.model.Link;
import com.myservices.urlshortener.dto.LinkDto;
import com.myservices.urlshortener.repository.LinkRepository;
import com.myservices.urlshortener.util.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class LinkService {

    private final LinkRepository linkRepository;

    private final ClickService clickService;

    @Value("${shortener.pathLength}")
    private String pathLength;

    @Autowired
    public LinkService(LinkRepository linkRepository, ClickService clickService) {
        this.linkRepository = linkRepository;
        this.clickService = clickService;
    }

    public Link addLink(LinkDto longUrl) {
        if (!longUrl.isUnique()) {
            ArrayList<Link> links = linkRepository.findAllByLongUrl(longUrl.getUrl());
            if (!links.isEmpty()) {
                return links.get(0);
            }
        }
        // todo: add timezone
        Link link = new Link(
                longUrl.getUrl(),
                StringTools.getRandomString(Integer.parseInt(pathLength)),
                LocalDateTime.now());
        linkRepository.saveAndFlush(link);
        return link;
    }

    public String processRedirect(String shortUrl, String userAgent) {
        Link link = Optional.ofNullable(linkRepository.findByShortUrl(shortUrl))
                .orElseThrow(LinkNotFound::new);
        if (!link.isActive()) {
            throw new LinkIsNotActiveException();
        }
        clickService.saveClick(link, userAgent);
        return link.getLongUrl();
    }

    public void deactivateLink(String shortUrl) {
        Link link = linkRepository.findByShortUrl(shortUrl);
        if (link != null) {
            link.setActive(false);
            linkRepository.save(link);
        }
    }
}
