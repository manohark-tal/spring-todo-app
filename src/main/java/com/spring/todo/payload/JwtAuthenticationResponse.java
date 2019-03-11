package com.spring.todo.payload;

import java.util.Date;

import com.spring.todo.models.AccessToken;

public class JwtAuthenticationResponse {
	private String accessToken;
	private String tokenType = "Bearer";
	private Date expiresAt;
	private long userId;

	public JwtAuthenticationResponse(AccessToken accessToken) {
		this.accessToken = accessToken.getId();
		this.expiresAt = accessToken.getExpiresAt();
		this.userId = accessToken.getUser().getId();
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	public long getUserId() {
		return userId;
	}

	public void setUser(long userId) {
		this.userId = userId;
	}

}