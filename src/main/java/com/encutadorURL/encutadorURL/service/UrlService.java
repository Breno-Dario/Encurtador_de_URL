package com.encutadorURL.encutadorURL.service;

import com.encutadorURL.encutadorURL.model.Url;
import com.encutadorURL.encutadorURL.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UrlService {

    private final UrlRepository repository;

    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }

    public Url createShortUrl(String originaUrl) {
        String shortCode = generateShortcode();

        Url url = new Url();
        url.setOriginalUrl(originaUrl);
        url.setShortcode(shortCode);
        url.setCreatedAt(LocalDateTime.now());

        return repository.save(url);
    }

    private String generateShortcode() {
        return UUID.randomUUID().toString().substring(0,6);
    }

    public Url getByShortcode(String code) {
        return repository.findByShortCode(code)
                .orElseThrow(() -> new RuntimeException("URL não encontrada"));
    }
}
