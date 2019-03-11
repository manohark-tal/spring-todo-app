package com.spring.todo.security.permissions;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import com.spring.todo.models.Todo;
import com.spring.todo.security.UserPrincipal;

public class CustomPermissionEvaluator implements PermissionEvaluator {
	@Autowired
	private TodoModelPermission todoModelPermission;

	@Override
	public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
		if ((auth == null) || (targetDomainObject == null) || !(permission instanceof String)) {
			return false;
		}
		String targetType = targetDomainObject.getClass().getSimpleName().toUpperCase();

		return hasOperationPermission(auth, targetDomainObject, targetType, permission.toString().toUpperCase());
	}

	@Override
	public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
		if ((auth == null) || (targetType == null) || !(permission instanceof String)) {
			return false;
		}
		return hasOperationPermission(auth, null, targetType.toUpperCase(), permission.toString().toUpperCase());
	}

	private boolean hasOperationPermission(Authentication auth, Object targetObject, String targetType,
			String permission) {

		switch (targetType) {
		case "TODO": {
			Todo todo = (Todo) targetObject;
			UserPrincipal user = (UserPrincipal) auth.getPrincipal();
			switch (permission) {
			case ModelPermission.READ:
				return todoModelPermission.hasReadPermission(todo, user);
			case ModelPermission.WRITE:
				return todoModelPermission.hasWritePermission(todo, user);
			case ModelPermission.DELETE:
				return todoModelPermission.hasDeletePermission(todo, user);
			}
		}
		}
		return false;
	}
}