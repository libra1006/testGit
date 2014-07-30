package com.github.Yasenia.flea_school.server;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;

import com.github.Yasenia.flea_school.server.entity.User;
import com.github.Yasenia.flea_school.server.service.IUserService;

public class UserServiceTest extends SpringBaseTest{
    @Inject
    private IUserService userService;
    @Test
    public void testSave(){
        User user = new User();
        user.setName("test01");
        user.setEmail("xxx@xxx.com");
        userService.save(user);
        assertNotNull(user.getId());
    }
}
