package com.myservices.urlshortener.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

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
    @OneToMany(mappedBy = "link")
    private Set<Click> clickSet;
    @Column(name = "is_active")
    private boolean isActive = true;

    protected Link() {
    }

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

    public Set<Click> getClickSet() {
        return clickSet;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return String.format(
                "Link[id=%d, longUrl='%s', shortUrl='%s', creationDate='%s']",
                id, longUrl, shortUrl, creationDate.toString());
    }
}
