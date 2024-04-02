package com.projects.securecap.repository.implementation;

import com.projects.securecap.domain.Role;
import com.projects.securecap.domain.User;

import java.util.Collection;

public interface RoleRepository<T extends Role>{

        T create (T data);
        Collection<T> list (int page, int pageSize);

        T get(Long id);

        T update(T update);

        Boolean delete(Long id);

        void addRoleToUser(Long userId, String roleName);

    }
