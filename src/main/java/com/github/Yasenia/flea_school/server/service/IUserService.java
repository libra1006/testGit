package com.github.Yasenia.flea_school.server.service;

import com.github.Yasenia.flea_school.server.entity.User;


public interface IUserService {
    public void save(User user);
    
    public User findById(String id);
}
