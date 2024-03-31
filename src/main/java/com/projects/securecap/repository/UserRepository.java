package com.projects.securecap.repository;


import com.projects.securecap.domain.User;

import java.util.Collection;

public interface UserRepository <T extends User>{

    T create (T data);
    Collection<T> list (int page, int pageSize);

    T get(Long id);

    T update(T update);

    Boolean delete(Long id);


}
