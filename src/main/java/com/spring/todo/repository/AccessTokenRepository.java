package com.spring.todo.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.todo.models.AccessToken;

@Repository
public interface AccessTokenRepository extends JpaRepository<AccessToken, String> {
	void deleteByExpiresAtLessThan(Date now);
}
