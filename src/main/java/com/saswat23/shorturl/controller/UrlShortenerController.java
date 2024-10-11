package com.saswat23.shorturl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saswat23.shorturl.entity.OriginalUrlInfoBean;
import com.saswat23.shorturl.entity.ShortUrlInfoBean;
import com.saswat23.shorturl.service.UrlShortenerService;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping
public class UrlShortenerController {

	@Autowired
	UrlShortenerService service;
	
	@GetMapping("/")
	public String home() {
		return "This is homepage...";
	}
	
	
	/**
	 * API to Generate short URL from the provided original URL
	 * @param urlInfo
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/generate", produces = "application/json")
	public ShortUrlInfoBean shortenUrl(@RequestBody OriginalUrlInfoBean urlInfo) {
		System.out.println("Original Url: "+urlInfo.toString());
		ShortUrlInfoBean shortUrlInfoBean = service.generateShortUrl(urlInfo);
		return shortUrlInfoBean;
	}
	
}
