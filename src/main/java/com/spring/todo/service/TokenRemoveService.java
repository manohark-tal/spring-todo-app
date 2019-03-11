package com.spring.todo.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.spring.todo.repository.AccessTokenRepository;

@Service
@Transactional
public class TokenRemoveService {

	@Autowired
	private AccessTokenRepository accessTokenRepository;

	@Scheduled(cron = "${app.cron}")
	public void removeExpired() {
		accessTokenRepository.deleteByExpiresAtLessThan(new Date());
	}
}