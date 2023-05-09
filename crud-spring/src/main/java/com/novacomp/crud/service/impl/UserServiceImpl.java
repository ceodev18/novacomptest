package com.novacomp.crud.service.impl;

import com.novacomp.crud.entity.User;
import com.novacomp.crud.repository.UserRepository;
import com.novacomp.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User findById(Long id) {
        return  userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        List<User>list = new ArrayList<>();
        userRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
