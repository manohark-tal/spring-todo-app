package com.spring.todo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.todo.models.User;
import com.spring.todo.payload.UserSummary;
import com.spring.todo.security.UserPrincipal;
import com.spring.todo.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "User Related Routes")
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/me")
	@ApiOperation(value = "Get User Details for given accessToken", response = UserSummary.class)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public UserSummary getCurrentUser() {
		UserPrincipal currentUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		UserSummary userSummary = new UserSummary(currentUser);
		return userSummary;
	}

	@GetMapping("/{userId}")
	@ApiOperation(value = "Get User Details for given userId", response = UserSummary.class)
	public UserSummary getUserById(@RequestParam Long userId) {
		User user = userService.findUserById(userId);
		UserSummary userSummary = new UserSummary(UserPrincipal.create(user));
		return userSummary;
	}

	@GetMapping("")
	@ApiOperation(value = "Get All Users Details in Application", response = UserSummary.class, responseContainer = "List")
	public List<UserSummary> getAllUsers() {
		List<User> allUsers = userService.getAllUsers();
		List<UserSummary> userSummaries = allUsers.stream()
				.map((currentUser) -> new UserSummary(UserPrincipal.create(currentUser))).collect(Collectors.toList());
		return userSummaries;
	}
}
