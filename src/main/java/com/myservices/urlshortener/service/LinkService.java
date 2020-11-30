package com.myservices.urlshortener.service;

import com.myservices.urlshortener.dto.Link;
import com.myservices.urlshortener.entities.RawLink;
import com.myservices.urlshortener.repositories.LinkRepository;
import com.myservices.urlshortener.utils.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
public class LinkService {

    private final LinkRepository linkRepository;

    @Value("${shortener.pathLength}")
    private String pathLength;

    @Autowired
    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Link addLink(RawLink longUrl) {
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
