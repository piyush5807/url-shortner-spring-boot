package com.example.geeksforgeeks.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlShortnerController {

    // 1. Inversion of Control - Spring will create objects for you, you don't have to create yourself
    // 2. Dependency injection - Injecting the dependency (importing the already created object by spring) in your current class

    @Autowired
    UrlShortener urlShortener;

    @GetMapping("/expand_url")
    public String getLongUrl(@RequestParam("url") String shortUrl) throws Exception {
        return urlShortener.expandUrl(shortUrl);
    }

    @GetMapping("/shorten_url")
    public String getShortUrl(@RequestParam("url") String longUrl){
        return urlShortener.shortenUrl(longUrl);
    }
}
