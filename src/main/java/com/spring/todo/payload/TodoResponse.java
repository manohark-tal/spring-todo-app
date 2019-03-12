package com.spring.todo.payload;

import java.time.Instant;
import java.util.Date;

import com.spring.todo.models.Todo;

public class TodoResponse {

	private Long id;

	private String description;

	private Date finishAt;

	private Long userId;
	private boolean isCompleted;
	private Instant createdAt;
	private Long createdBy;
	private Instant updatedAt;
	private Long updatedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public TodoResponse(Long id, String description, Date finishAt, Long userId, boolean isCompleted, Instant createdAt,
			Long createdBy, Instant updatedAt, Long updatedBy) {
		super();
		this.id = id;
		this.description = description;
		this.finishAt = finishAt;
		this.userId = userId;
		this.isCompleted = isCompleted;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}

	public TodoResponse() {
		super();
	}

	public TodoResponse(Todo todo) {
		super();
		this.id = todo.getId();
		this.description = todo.getDescription();
		this.finishAt = todo.getFinishAt();
		this.userId = todo.getUser().getId();
		this.isCompleted = todo.isCompleted();
		this.createdAt = todo.getCreatedAt();
		this.createdBy = todo.getCreatedBy();
		this.updatedAt = todo.getUpdatedAt();
		this.updatedBy = todo.getUpdatedBy();
	}

}
