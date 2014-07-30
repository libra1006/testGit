package com.github.Yasenia.flea_school.server.service.impl;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.Yasenia.flea_school.server.dao.IUserDAO;
import com.github.Yasenia.flea_school.server.entity.User;
import com.github.Yasenia.flea_school.server.service.IUserService;

@Named("userService")
public class UserServiceImpl implements IUserService {
    @Inject
    @Named("userDAO")
    private IUserDAO userDAO;
    

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(User user) {
        user.setRegisterDate(new Date());
        userDAO.save(user);
        System.out.println("User saving:");
        System.out.println("id: " + user.getId());
        System.out.println("password: " + user.getPassword());
        System.out.println("register date: " + user.getRegisterDate());
    }
}
