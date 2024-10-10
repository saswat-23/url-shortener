package com.saswat23.shorturl.model;

import java.sql.Timestamp;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UrlInfoModel {

	private String originalUrl;
	private String shortUrl;
	private Long urlExpiry;
	private String createBy;
	private Timestamp createdAt;
	private String status;
	
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
	
	public Long getUrlExpiry() {
		return urlExpiry;
	}
	public void setUrlExpiry(Long urlExpiry) {
		this.urlExpiry = urlExpiry;
	}
	
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "UrlInfo [originalUrl=" + originalUrl + ", shortUrl=" + shortUrl + ", urlExpiry=" + urlExpiry
				+ ", createBy=" + createBy + ", createdAt=" + createdAt + ", status=" + status + "]";
	}
	
}
