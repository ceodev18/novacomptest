package com.novacomp.crud.service;

import com.novacomp.crud.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User findById(Long id);

    List<User>getAll();

    User saveUser(User user);

    User updateUser(User user);
}
