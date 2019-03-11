package com.spring.todo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.todo.models.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

	public List<Todo> findByUserId(Long userId);

	public Page<Todo> findByUserId(Long userId, Pageable pageable);
}
