package com.saswat23.shorturl.entity;

public class OriginalUrlInfoBean {

	private String originalUrl;
	private Long urlExpiry;
	
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public Long getUrlExpiry() {
		return urlExpiry;
	}
	public void setUrlExpiry(Long urlExpiry) {
		this.urlExpiry = urlExpiry;
	}
	
	@Override
	public String toString() {
		return "OriginalUrlInfo [originalUrl=" + originalUrl + ", urlExpiry=" + urlExpiry + "]";
	}
	
}
