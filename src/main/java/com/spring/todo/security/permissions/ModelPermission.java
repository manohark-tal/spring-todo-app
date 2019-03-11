package com.spring.todo.security.permissions;

import com.spring.todo.security.UserPrincipal;

public interface ModelPermission<E> {
	String READ = "READ";
	String WRITE = "WRITE";
	String DELETE = "DELETE";

	public boolean hasReadPermission(E e, UserPrincipal user);

	public boolean hasWritePermission(E e, UserPrincipal user);

	public boolean hasDeletePermission(E e, UserPrincipal user);

}
