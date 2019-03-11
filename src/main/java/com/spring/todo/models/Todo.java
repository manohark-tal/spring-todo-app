package com.spring.todo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.spring.todo.models.audit.UserDateAudit;

@Entity
@Table(name = "todos")
public class Todo extends UserDateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "description")
	private String description;

	@Column(name = "finish_at")
	private Date finishAt;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@Column(name = "is_completed")
	private boolean isCompleted;

	public Todo() {
		super();
	}

	public Todo(Long id, String description, Date finishAt, User user, boolean isCompleted) {
		super();
		this.id = id;
		this.description = description;
		this.finishAt = finishAt;
		this.user = user;
		this.isCompleted = isCompleted;
	}

	public Todo(String description, Date finishAt, User user) {
		super();
		this.description = description;
		this.finishAt = finishAt;
		this.user = user;
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

}
