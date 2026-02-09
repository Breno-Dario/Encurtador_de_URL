package com.encutadorURL.encutadorURL.controller;

import com.encutadorURL.encutadorURL.dto.CreateUrlRequest;
import com.encutadorURL.encutadorURL.model.Url;
import com.encutadorURL.encutadorURL.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/urls")
public class UrlController {

    private final UrlService service;

    public UrlController(UrlService service) {
        this.service = service;
    }

    @PostMapping
    public Url create(@RequestBody CreateUrlRequest request) {
        return service.createShortUrl(request.getOriginalUrl());
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {
        Url url = service.getByShortcode(code);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(url.getOriginalUrl()))
                .build();
    }
}
