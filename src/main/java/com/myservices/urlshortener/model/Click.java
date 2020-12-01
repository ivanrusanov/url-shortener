package com.myservices.urlshortener.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "click")
public class Click {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "click_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime clickDateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "link_id", nullable = false)
    private Link link;
    @Column(name = "user_agent")
    private String userAgent;

    public Click() {
    }

    public Click(LocalDateTime clickDateTime, Link link, String userAgent) {
        this.clickDateTime = clickDateTime;
        this.link = link;
        this.userAgent = userAgent;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getClickDateTime() {
        return clickDateTime;
    }

    public Link getLink() {
        return link;
    }

    public String getUserAgent() {
        return userAgent;
    }
}
