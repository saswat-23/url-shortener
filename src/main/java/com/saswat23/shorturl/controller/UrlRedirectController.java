package com.saswat23.shorturl.controller;

import java.io.IOException;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.saswat23.shorturl.service.UrlShortenerService;

@RestController
@CrossOrigin(origins = "*")
public class UrlRedirectController {

	@Autowired
	UrlShortenerService service;
	
	/**
	 * API to fetch the original URL from short URL and redirect to the original URL
	 * @param shortUrl
	 * @param redirectAttributes
	 * @return
	 * @throws IOException
	 */
	@GetMapping("/{shortUrl}")
	public ResponseEntity<?> redirectToOriginalUrl(@PathVariable("shortUrl") String shortUrl, RedirectAttributes redirectAttributes) {
		System.out.println("The short Url is: "+shortUrl);
		String originalUrl = service.getOriginalUrlInfoFromShortUrl(shortUrl);
		System.out.println("Original Url: "+originalUrl);
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(URI.create(originalUrl));
	    return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
	}
}
