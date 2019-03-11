package com.spring.todo.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.todo.exception.AppException;
import com.spring.todo.models.AccessToken;
import com.spring.todo.models.User;
import com.spring.todo.repository.AccessTokenRepository;

@Service
@Transactional
public class AccessTokenService {
	@Autowired
	private AccessTokenRepository accessTokenRepository;

	public AccessToken createAccessToken(String token, User user, Date expiresAt) {
		AccessToken accessToken = new AccessToken(token, user, expiresAt);

		return accessTokenRepository.save(accessToken);
	}

	public void removeAccessToken(String token) {
		accessTokenRepository.deleteById(token);
	}

	public AccessToken getAccessToken(String token) {
		AccessToken accessToken = accessTokenRepository.findById(token)
				.orElseThrow(() -> new AppException("Token is Not Present"));
		return accessToken;
	}
}
