package com.saswat23.shorturl.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saswat23.shorturl.entity.OriginalUrlInfoBean;
import com.saswat23.shorturl.entity.ShortUrlInfoBean;
import com.saswat23.shorturl.model.UrlInfoModel;
import com.saswat23.shorturl.repo.UrlShortenerRepo;
import com.saswat23.shorturl.utils.AppUtils;

@Service
public class UrlShortenerService {

	@Autowired
	UrlShortenerRepo repo;
	
	String shortUrl = "";
	final String STARTS_WITH_HTTPS = "https://";
	final String STARTS_WITH_HTTP = "http://";
	
	
	public ShortUrlInfoBean generateShortUrl(OriginalUrlInfoBean originalUrlInfoBean){

		//Generate the short URL
		shortUrl = AppUtils.generateShortUrlString();
		
		//Create ShortUrlInfoBean from all the URL Info
		ShortUrlInfoBean shortUrlInfoBean = new ShortUrlInfoBean(originalUrlInfoBean.getOriginalUrl(), shortUrl, true);
		
		// Save all URL info in the DB
		int res = repo.saveShortUrl(shortUrlInfoBean);
		
		/* If -1 is returned while saving, it means an entry already exist in the DB for the short URL,
		*  hence a new short URL will be generated
		*/
		if(res == -1) {
			shortUrlInfoBean = generateShortUrl(originalUrlInfoBean);
		}
		
		return shortUrlInfoBean;
	}
	
	
	/**
	 * Extracts the original URL from the short url
	 * @param shortUrl
	 * @return
	 */
	public String getOriginalUrlInfoFromShortUrl(String shortUrl) {
		String originalUrl = null;
		List<UrlInfoModel> urlInfoList = repo.getUrlInfoByShortUrl(shortUrl);
		if(urlInfoList.size()>0) {
			originalUrl = urlInfoList.get(0).getOriginalUrl();
		}
		
		// Sanitize the Original URL to add http or https protocol at the start if not present
		return sanitizeUrlString(originalUrl);
	}
	
	
	/**
	 * Adds http or https protocol at the start of the URL string if it is not already present.
	 * @param originalUrlStr
	 * @return
	 */
	public String sanitizeUrlString(String originalUrlStr) {
		if(!originalUrlStr.startsWith(STARTS_WITH_HTTPS) &&
				!originalUrlStr.startsWith(STARTS_WITH_HTTP)) {
			return StringUtils.prependIfMissingIgnoreCase(originalUrlStr, STARTS_WITH_HTTP);
		}
		return originalUrlStr;
	}
	
}
