package com.github.Yasenia.flea_school.server.action;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.Yasenia.flea_school.server.entity.User;
import com.github.Yasenia.flea_school.server.exception.DBException;
import com.github.Yasenia.flea_school.server.service.IUserService;

@Controller
public class UserAction {
    @Inject
    @Named("userService")
    private IUserService userService;
    
    public static final String REGISTER_INPUT = "/register";
    public static final String REGISTER_SUCCESS = "/registerSuccess";
    public static final String LOGIN_INPUT = "/login";
    public static final String HOME = "/home";

    /**
     * 用户访问注册url，定向跳转至注册视图
     * */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String setUpRegister(Model model, User user) {
        model.addAttribute("user", user);
        return REGISTER_INPUT;
    }
    
    /**
     * 注册页面提交表单
     * */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String submitRegister(@ModelAttribute(value="user") User user,
            Model model) {
        try {
            userService.save(user);
        }
        catch (DBException ex) {
            return REGISTER_INPUT;
        }
        return REGISTER_SUCCESS;
    }
    
    /**
     * 用户访问登录url，定向跳转至登录视图
     * */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String setUpLogin(Model model, User user) {
        model.addAttribute("user", user);
        return LOGIN_INPUT;
    }
    
    /**
     * 登录页面提交表单
     * */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submitLogin(@ModelAttribute(value="user") User user,
            Model model) {
        User realUser = userService.findById(user.getId());
        if (realUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("user", realUser);
            return "redirect:" + HOME;
        }
        else {
            return LOGIN_INPUT;
        }
    }
    
}
