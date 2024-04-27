package com.ali.java.todo.service.impl;

import com.ali.java.todo.model.User;
import com.ali.java.todo.repository.UserRepository;
import com.ali.java.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {



    private final UserRepository userRepository;

    @Override
    public User save(User user) {

        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        User oldUser = userRepository.findById(user.getId()).orElse(null);
        oldUser.setUserName(user.getUserName());
        oldUser.setCategory(user.getCategory());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        return oldUser;
    }

    @Override
    public List<User> findAll() {
       return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {

        return userRepository.findById(id).orElse(null);
    }

    @Override
    public String delete(Long id) {

        userRepository.deleteById(id);
        return "Deleted";

    }


}
