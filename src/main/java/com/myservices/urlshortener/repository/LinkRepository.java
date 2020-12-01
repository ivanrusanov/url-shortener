package com.myservices.urlshortener.repository;

import com.myservices.urlshortener.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface LinkRepository extends JpaRepository<Link, Long> {
    Link findByShortUrl(String shortUrl);
    ArrayList<Link> findAllByLongUrl(String longUrl);
}
