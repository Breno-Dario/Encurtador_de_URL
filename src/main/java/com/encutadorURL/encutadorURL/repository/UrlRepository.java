package com.encutadorURL.encutadorURL.repository;

import com.encutadorURL.encutadorURL.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url,Long> {
    Optional<Url> findByShortCode(String shortCode);

}
