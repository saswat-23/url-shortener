package com.saswat23.shorturl.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SimplePropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.saswat23.shorturl.dto.ShortUrlInfoDTO;
import com.saswat23.shorturl.model.UrlInfoModel;

@Repository
public class UrlShortenerRepo {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int saveShortUrl(ShortUrlInfoDTO urlInfoBean) {
		
		//Persistence logic to check the existence of the generated ShortURl
		// Then save the generated ShortUrl if it is not already present in the DB
		// If the ShortUrl already exist, then re-generate the ShortUrl for the given Original Url
		if(getUrlInfoByShortUrl(urlInfoBean.getShortUrl()).size() > 0) {
			return -1;
		}
		
		String sql = "insert into url_info (original_url, short_url, status) values (?,?,?)";
		String[] params = {urlInfoBean.getOriginalUrl(), urlInfoBean.getShortUrl(), "active"};
		int res = jdbcTemplate.update(sql, params);
		return res;
	}
	
	public List<UrlInfoModel> getUrlInfoByShortUrl(String shortUrl) {
		String sql = "select * from url_info where short_url = ?";
		List<UrlInfoModel> urlInfo = jdbcTemplate.query(sql, new String[]{shortUrl}, new SimplePropertyRowMapper(UrlInfoModel.class));
		return urlInfo;
	}
	
}
