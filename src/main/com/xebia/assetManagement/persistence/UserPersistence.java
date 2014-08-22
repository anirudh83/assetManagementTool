package com.xebia.assetManagement.persistence;

import com.xebia.assetManagement.model.User;

import java.util.List;

/**
 * Created by anirudh on 22/08/14.
 */
public interface UserPersistence extends GenericDAO<User,Long>{
    List<User> getAllUsers();
    User getUserByEmail(String email);
}
