package com.saswat23.shorturl.dto;

public class ShortUrlInfoDTO {

	private String originalUrl;
	private String shortUrl;
	private boolean isUrlActive;
	
	public ShortUrlInfoDTO() {}
	
	public ShortUrlInfoDTO(String originalUrl, String shortUrl, boolean isUrlActive) {
		this.originalUrl = originalUrl;
		this.shortUrl = shortUrl;
		this.isUrlActive = isUrlActive;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	
	public boolean isUrlActive() {
		return isUrlActive;
	}
	public void setIsUrlActive(boolean isActive) {
		this.isUrlActive = isActive;
	}
	
	@Override
	public String toString() {
		return "ShortUrlInfo [originalUrl=" + originalUrl + ", shortUrl=" + shortUrl + ", isActive=" + isUrlActive + "]";
	}
	
	
	
}
