package com.myservices.urlshortener.repository;

import com.myservices.urlshortener.model.Click;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClickRepository extends JpaRepository<Click, Long> {
}
