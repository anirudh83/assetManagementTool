package com.xebia.assetManagement.service;

import com.xebia.assetManagement.model.User;

import java.util.List;

/**
 * Created by anirudh on 22/08/14.
 */
public interface UserService {
    List<User> getUsers();
    User getUserById(Long id);
    User getUserByEmail(String emailAddress);
    User createUser(User newUser);

}
