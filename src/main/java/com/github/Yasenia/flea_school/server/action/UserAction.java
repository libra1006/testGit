package com.github.Yasenia.flea_school.server.action;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.Yasenia.flea_school.server.entity.User;
import com.github.Yasenia.flea_school.server.service.IUserService;

@Controller
public class UserAction {
    @Inject
    @Named("userService")
    private IUserService userService;
    
    public static final String REGISTER_INPUT = "/register";
    public static final String LOGIN_INPUT = "/login";
    

    /**
     * 用户访问注册url，定向跳转至注册视图
     * */
    @RequestMapping(value = {"/register", "register"}, method = RequestMethod.GET)
    public String setUpRegister(Model model, User user) {
        model.addAttribute("user", user);
        System.out.println("123");
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
        catch (RuntimeException re) {
            System.out.println("异常");
            re.printStackTrace();
        }
        
        return REGISTER_INPUT;
    }
    
    
}
