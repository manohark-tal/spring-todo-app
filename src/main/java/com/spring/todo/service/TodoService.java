package com.spring.todo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.spring.todo.models.Todo;
import com.spring.todo.payload.PagedResponse;
import com.spring.todo.payload.TodoRequest;
import com.spring.todo.repository.TodoRepository;
import com.spring.todo.repository.UserRepository;
import com.spring.todo.security.UserPrincipal;
import com.spring.todo.utils.Validator;

@Service
@Transactional
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	@Autowired
	private UserRepository userRepository;

	@PreAuthorize("hasRole('ADMIN') or  #user.id == #userId")
	public PagedResponse<Todo> getTodos(UserPrincipal user, long userId, int page, int size) {
		Validator.validatePageNumberAndSize(page, size);
		Pageable pageable = PageRequest.of(page, size);
		Page<Todo> todos = todoRepository.findByUserId(userId, pageable);
		return new PagedResponse<Todo>(todos.getContent(), todos.getNumber(), todos.getSize(), todos.getTotalElements(),
				todos.getTotalPages(), todos.isLast());
	}

	@PreAuthorize("hasRole('ADMIN')")
	public PagedResponse<Todo> getTodos(int page, int size) {
		Validator.validatePageNumberAndSize(page, size);
		Pageable pageable = PageRequest.of(page, size);
		Page<Todo> todos = todoRepository.findAll(pageable);
		return new PagedResponse<Todo>(todos.getContent(), todos.getNumber(), todos.getSize(), todos.getTotalElements(),
				todos.getTotalPages(), todos.isLast());
	}

	@PreAuthorize("hasRole('ADMIN') or #user.id == #userId")
	public Todo addTodo(UserPrincipal user, TodoRequest todoRequest, long userId) {
		if (user.getId() != userId) {

		} else {
		}
		return null;
	}

}
