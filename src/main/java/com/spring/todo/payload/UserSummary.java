package com.spring.todo.payload;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.spring.todo.security.UserPrincipal;

public class UserSummary {
	private Long id;
	private String username;
	private String name;
	private String email;
	private Collection<? extends GrantedAuthority> authorities;

	public UserSummary(Long id, String username, String name, String email) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.email = email;
	}

	public UserSummary(UserPrincipal principal) {
		this.id = principal.getId();
		this.username = principal.getUsername();
		this.name = principal.getName();
		this.email = principal.getEmail();
		this.authorities = principal.getAuthorities();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}