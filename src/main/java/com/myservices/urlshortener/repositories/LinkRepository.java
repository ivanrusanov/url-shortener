package com.myservices.urlshortener.repositories;

import com.myservices.urlshortener.dto.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
