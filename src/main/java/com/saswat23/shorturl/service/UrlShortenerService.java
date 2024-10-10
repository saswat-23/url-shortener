package com.saswat23.shorturl.service;

import java.util.List;

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
	
	String dummyShortUrl = "";
//	String dummyLongUrl1 = "https://www.amazon.in/pTron-compatible-Smartphones-Gold-plated-Tangle-free/dp/B09KS55PRR/";
//	String dummyLongUrl2 = "https://www.javatpoint.com/spring-boot-starter-data-jpa";
//	String dummyLongUrl3 = "https://www.flipkart.com/noise-vision-3-1-96-amoled-display-thin-bezel-metallic-build-smartwatch/p/itm86cb485141549";
	
	
	public ShortUrlInfoBean generateShortUrl(OriginalUrlInfoBean originalUrlInfoBean){

		//Generate the short URL
		dummyShortUrl = AppUtils.generateShortUrlString();
		
		
		//Create ShortUrlInfoBean from all the URL Info
		ShortUrlInfoBean shortUrlInfoBean = new ShortUrlInfoBean(originalUrlInfoBean.getOriginalUrl(), dummyShortUrl, true);
		
		// Save all URL info in the DB
		int res = repo.saveShortUrl(shortUrlInfoBean);
		
		if(res == -1) {
			shortUrlInfoBean = generateShortUrl(originalUrlInfoBean);
		}
		
		return shortUrlInfoBean;
	}
	
	public String getOriginalUrlInfoFromShortUrl(String shortUrl) {
		String originalUrl = "";
		List<UrlInfoModel> urlInfoList = repo.getUrlInfoByShortUrl(shortUrl);
		if(urlInfoList.size()>0) {
			originalUrl = urlInfoList.get(0).getOriginalUrl();
		}
		return originalUrl;
	}
	
}
