package com.myservices.urlshortener.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String longUrl;
    private String shortUrl;
    private LocalDate creationDate;

    protected Link() {}

    public Link(String longUrl, String shortUrl, LocalDate creationDate) {
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return String.format(
                "Link[id=$d, longUrl='%s', shortUrl='%s', creationDate='%s']",
                id, longUrl, shortUrl, creationDate.toString());
    }
}
