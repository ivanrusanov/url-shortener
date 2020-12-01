package com.myservices.urlshortener.service;

import com.myservices.urlshortener.model.Link;
import com.myservices.urlshortener.dto.LinkDto;
import com.myservices.urlshortener.repository.LinkRepository;
import com.myservices.urlshortener.util.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LinkService {

    private final LinkRepository linkRepository;

    @Value("${shortener.pathLength}")
    private String pathLength;

    @Autowired
    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Link addLink(LinkDto longUrl) {
        // todo: add timezone
        Link link = new Link(
                longUrl.getUrl(),
                StringTools.getRandomString(Integer.parseInt(pathLength)),
                LocalDateTime.now());
        linkRepository.saveAndFlush(link);
        return link;
    }

    public String getRedirectUrl(String shortUrl) {
        Link link = linkRepository.findByShortUrl(shortUrl);
        // todo: I think it's not the best place for counter incrementation
        link.incrementClickCount();
        linkRepository.save(link);
        return link.getLongUrl();
    }
}
