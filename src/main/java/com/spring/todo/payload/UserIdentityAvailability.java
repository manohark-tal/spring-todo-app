package com.spring.todo.payload;

public class UserIdentityAvailability {
	private Boolean available;

	public UserIdentityAvailability(Boolean available) {
		this.available = available;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
}