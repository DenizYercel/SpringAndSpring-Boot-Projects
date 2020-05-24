package com.deniz.dao;

import com.deniz.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}
