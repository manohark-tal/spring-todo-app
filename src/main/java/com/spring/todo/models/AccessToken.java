package com.spring.todo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "access_token")
public class AccessToken {

	@Id
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@Column(name = "expires_at", nullable = false)
	private Date expiresAt;

	public AccessToken(String id, User user, Date expiresAt) {
		super();
		this.id = id;
		this.user = user;
		this.expiresAt = expiresAt;
	}

	public AccessToken() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

}
