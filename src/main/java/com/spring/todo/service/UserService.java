package com.spring.todo.service;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.todo.exception.AppException;
import com.spring.todo.models.Role;
import com.spring.todo.models.RoleName;
import com.spring.todo.models.User;
import com.spring.todo.repository.RoleRepository;
import com.spring.todo.repository.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public User createUser(String name, String username, String email, String password) {
		// Creating user's account
		User user = new User(name, username, email, password);

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
				.orElseThrow(() -> new AppException("User Role not set."));

		user.setRoles(Collections.singleton(userRole));

		User result = userRepository.save(user);
		return result;
	}

	@PreAuthorize("hasRole('ADMIN')")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public User findUserById(long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new AppException("Unable to find User with given Id"));
	}
}
