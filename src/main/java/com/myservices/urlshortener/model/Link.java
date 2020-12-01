package com.myservices.urlshortener.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "link")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "long_url")
    private String longUrl;
    @Column(name = "short_url" /*, unique=true*/)
    private String shortUrl;
    @Column(name = "creation_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime creationDate;
    @Column(name = "click_count")
    private int clickCount;

    protected Link() {}

    public Link(String longUrl, String shortUrl, LocalDateTime creationDate) {
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void incrementClickCount() {
        clickCount++;
    }

    @Override
    public String toString() {
        return String.format(
                "Link[id=%d, longUrl='%s', shortUrl='%s', creationDate='%s']",
                id, longUrl, shortUrl, creationDate.toString());
    }
}