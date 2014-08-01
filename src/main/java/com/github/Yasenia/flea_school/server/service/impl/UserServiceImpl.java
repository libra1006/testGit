package com.github.Yasenia.flea_school.server.service.impl;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.Yasenia.flea_school.server.dao.IUserDAO;
import com.github.Yasenia.flea_school.server.entity.User;
import com.github.Yasenia.flea_school.server.exception.DBException;
import com.github.Yasenia.flea_school.server.service.IUserService;

@Named("userService")
public class UserServiceImpl implements IUserService {
    @Inject
    @Named("userDAO")
    private IUserDAO userDAO;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(User user) {
        if (userDAO.findById(user.getId()) == null) {
            user.setRegisterDate(new Date());
            user.setCoin(0);
            user.setPoint(0);
            userDAO.save(user);
        }
        else {
            throw new DBException("注册id已经存在。");
        }
    }

    @Override
    public User findById(String id) {
        return userDAO.findById(id);
    }
}
