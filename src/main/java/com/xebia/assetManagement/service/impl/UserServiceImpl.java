package com.xebia.assetManagement.service.impl;

import com.xebia.assetManagement.model.User;
import com.xebia.assetManagement.persistence.UserPersistence;
import com.xebia.assetManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by anirudh on 22/08/14.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserPersistence userPersistence;

    @Override
    public List<User> getUsers() {
        return userPersistence.getAllUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userPersistence.findById(id);
    }

    @Override
    public User getUserByEmail(String emailAddress) {
        return userPersistence.getUserByEmail(emailAddress);
    }

    @Override
    public User createUser(User user) {
        return userPersistence.makePersistant(user);
    }


}
