package com.saswat23.shorturl.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saswat23.shorturl.entity.OriginalUrlInfoBean;
import com.saswat23.shorturl.entity.ShortUrlInfoBean;
import com.saswat23.shorturl.service.UrlShortenerService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class UrlShortenerController {

	@Autowired
	UrlShortenerService service;
	
	@GetMapping("/")
	public String home() {
		return "This is homepage...";
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/generate", produces = "application/json")
	public ShortUrlInfoBean shortenUrl(@RequestBody OriginalUrlInfoBean urlInfo) {
		System.out.println("Original Url: "+urlInfo.toString());
		ShortUrlInfoBean shortUrlInfoBean = service.generateShortUrl(urlInfo);
		return shortUrlInfoBean;
	}
	
	@GetMapping("/redirect/{shortUrl}")
	public ResponseEntity<?> redirectToOriginalUrl(@PathVariable("shortUrl") String shortUrl, HttpServletResponse response) throws IOException {
		System.out.println("The short Url is: "+shortUrl);
		String originalUrl = service.getOriginalUrlInfoFromShortUrl(shortUrl);
		System.out.println("Original Url: "+originalUrl);
		response.sendRedirect(originalUrl);
		return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, originalUrl).build();
//		return originalUrl;
	}
	
	
	
}
