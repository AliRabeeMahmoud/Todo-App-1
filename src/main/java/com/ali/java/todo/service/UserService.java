package com.ali.java.todo.service;

import com.ali.java.todo.model.User;

import java.util.List;


public interface UserService {

    User save(User user);
    User update(User user);

    List<User> findAll();

    User findById(Long id);

    String delete(Long id);


}
