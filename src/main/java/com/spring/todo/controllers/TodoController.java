package com.spring.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.todo.AppConstants;
import com.spring.todo.models.Todo;
import com.spring.todo.payload.PagedResponse;
import com.spring.todo.payload.TodoRequest;
import com.spring.todo.security.UserPrincipal;
import com.spring.todo.service.TodoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/todos")
@Api(value = "Todo Related Routes")
public class TodoController {
	@Autowired
	private TodoService todoService;

	@GetMapping("/{userId}")
	@ApiOperation(value = "Get Todo Details in Application", response = PagedResponse.class)
	public PagedResponse<Todo> getTodos(@PathVariable Long userId,
			@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
			@RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
		UserPrincipal currentUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return todoService.getTodos(currentUser, userId, page, size);
	}

	@GetMapping("")
	@ApiOperation(value = "Get Todo Details in Application", response = PagedResponse.class)
	public PagedResponse<Todo> getTodos(
			@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
			@RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
		return todoService.getTodos(page, size);
	}

	@PostMapping("/{userId}")
	@ApiOperation(value = "Add Todo Details for Given User", response = PagedResponse.class)
	public ResponseEntity<?> addTodo(@RequestBody TodoRequest todoRequest) {

		return null;
	}

}
