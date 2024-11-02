package com.saswat23.shorturl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saswat23.shorturl.dto.OriginalUrlInfoDTO;
import com.saswat23.shorturl.dto.ShortUrlInfoDTO;
import com.saswat23.shorturl.service.UrlShortenerService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/shorten")
public class UrlShortenerController {

	@Autowired
	UrlShortenerService service;
	
	
	/**
	 * API to Generate short URL from the provided original URL
	 * @param urlInfo
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/generate", produces = "application/json")
	public ShortUrlInfoDTO shortenUrl(@RequestBody OriginalUrlInfoDTO urlInfo) {
		System.out.println("Original Url: "+urlInfo.toString());
		ShortUrlInfoDTO shortUrlInfoDTO = service.generateShortUrl(urlInfo);
		return shortUrlInfoDTO;
	}
	
}
