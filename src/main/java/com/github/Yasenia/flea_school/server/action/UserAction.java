package com.github.Yasenia.flea_school.server.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.github.Yasenia.flea_school.server.entity.User;
import com.github.Yasenia.flea_school.server.exception.DBException;
import com.github.Yasenia.flea_school.server.service.IUserService;

@Controller
@SessionAttributes(value = {"user"})
public class UserAction {
    @Autowired
    private IUserService userService;
    
    public static final String REGISTER_INPUT = "register";
    public static final String REGISTER_SUCCESS = "registerSuccess";
    public static final String LOGIN_INPUT = "login";
    public static final String HOME_INPUT = "home";
    public static final String HOME_PAGE = "homePage";

    /**
     * 初始化模型对象中参数"user"
     * */
    @ModelAttribute("user")
    public User initUser() {
        User user = new User();
        return user;
    }
    
    /**
     * 用户访问注册url，定向跳转至注册视图
     * */
    @RequestMapping(value = REGISTER_INPUT, method = RequestMethod.GET)
    public String setUpRegister() {
        return REGISTER_INPUT;
    }
    
    /**
     * 注册页面提交表单
     * */
    @RequestMapping(value = REGISTER_INPUT, method = RequestMethod.POST)
    public String submitRegister(@ModelAttribute(value="registUser") User user) {
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
    @RequestMapping(value = LOGIN_INPUT, method = RequestMethod.GET)
    public String setUpLogin() {
        return LOGIN_INPUT;
    }
    
    /**
     * 登录页面提交表单
     * */
    @RequestMapping(value = LOGIN_INPUT, method = RequestMethod.POST)
    public String submitLogin(@ModelAttribute(value="loginUser") User user,
            Model model) {
        User realUser = userService.findByUserName(user.getUserName());
        if (realUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("user", realUser);
            System.out.println("登录成功");
            return "redirect:" + HOME_INPUT;
        }
        else {
            return LOGIN_INPUT;
        }
    }
    
    /**
     * 用户访问主页面url，定向跳转至主页面视图
     * */
    @RequestMapping(value = HOME_INPUT)
    public ModelAndView setUpHome(@ModelAttribute(value="user") User user) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(HOME_PAGE);
        return mv;
    }
}
