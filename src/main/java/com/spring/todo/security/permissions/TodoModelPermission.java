package com.spring.todo.security.permissions;

import org.springframework.stereotype.Service;

import com.spring.todo.models.Todo;
import com.spring.todo.security.UserPrincipal;

@Service
public class TodoModelPermission implements ModelPermission<Todo> {

	@Override
	public boolean hasReadPermission(Todo e, UserPrincipal user) {
		// TODO Auto-generated method stub
		return e.getUser().getId().equals(user.getId());
	}

	@Override
	public boolean hasWritePermission(Todo e, UserPrincipal user) {
		// TODO Auto-generated method stub
		return e.getUser().getId().equals(user.getId());

	}

	@Override
	public boolean hasDeletePermission(Todo e, UserPrincipal user) {
		// TODO Auto-generated method stub
		return e.getUser().getId().equals(user.getId());

	}

}
