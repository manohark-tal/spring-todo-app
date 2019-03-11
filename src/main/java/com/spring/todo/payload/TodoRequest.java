package com.spring.todo.payload;

import java.util.Date;

public class TodoRequest {

	private String description;

	private Date finishAt;

	public TodoRequest(String description, Date finishAt, Long userId) {
		super();
		this.description = description;
		this.finishAt = finishAt;
	}

	public TodoRequest() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getFinishAt() {
		return finishAt;
	}

	public void setFinishAt(Date finishAt) {
		this.finishAt = finishAt;
	}

}
