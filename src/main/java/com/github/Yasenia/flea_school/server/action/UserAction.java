package com.github.Yasenia.flea_school.server.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.github.Yasenia.flea_school.server.entity.Goods;
import com.github.Yasenia.flea_school.server.entity.School;
import com.github.Yasenia.flea_school.server.entity.User;
import com.github.Yasenia.flea_school.server.exception.DBException;
import com.github.Yasenia.flea_school.server.service.ICommonService;
import com.github.Yasenia.flea_school.server.service.IGoodsService;
import com.github.Yasenia.flea_school.server.service.IUserService;

/**
 * UserAction
 * 
 * @author Yasenia (458875608@qq.com)
 * */
@Controller
@SessionAttributes(value = { "user" })
public class UserAction {
    /**
     * 用户访问 URL
     * */
    public static final String REGISTER_URL = "/register";
    public static final String LOGIN_URL = "/login";
    public static final String HOME_URL = "/home";
    public static final String LOGOUT_URL = "/logout";
    public static final String USER_CENTER_URL = "/userCenter";
    
    /**
     * 视图名
     * */
    public static final String REGISTER_VIEW = "user/register";
    public static final String LOGIN_VIEW = "user/login";
    public static final String HOME_VIEW = "user/home";
    public static final String USER_CENTER_VIEW = "user/userCenter";
    public static final String REGISTER_SUCCESS_VIEW = "user/registerSuccess";
    
    /**
     * 表单提交请求 URL
     * */
    public static final String REGISTER_ACTION = "registerAction";
    public static final String LOGIN_ACTION = "loginAction";
    
    /**
     * service对象
     * */
    @Autowired
    private IUserService userService;
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private ICommonService commonService;

    
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
    @RequestMapping(value = REGISTER_URL, method = RequestMethod.GET)
    public String setUpRegister() {
        return REGISTER_VIEW;
    }
    
    /**
     * 用户访问登录url，定向跳转至登录视图
     * */
    @RequestMapping(value = LOGIN_URL, method = RequestMethod.GET)
    public String setUpLogin() {
        return LOGIN_VIEW;
    }    
    
    /**
     * 用户访问主页面url，定向跳转至主页面视图
     * */
    @RequestMapping(value = HOME_URL, method = RequestMethod.GET)
    public ModelAndView setUpHome(@ModelAttribute(value = "user") User user) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(HOME_VIEW);
        List<Goods> goodsList = null;
        if (user != null && user.getId() != null) {
            Integer schoolId = user.getSchool().getId();
            goodsList = goodsService.findGoodsBySchoolId(schoolId);
        }
        else {
            goodsList = goodsService.findAll(0, 20);
        }
        mv.addObject("goodsList", goodsList);
        return mv;
    }
    
    /**
     * 用户访问退出登录url，定向跳转至主页
     * */
    @RequestMapping(value = LOGOUT_URL, method = RequestMethod.GET)
    public String setUpLogout(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "redirect:" + HOME_URL;
    }
    
    /**
     * 用户访问用户中心url，定向跳转至用户中心
     * */
    @RequestMapping(value = USER_CENTER_URL, method = RequestMethod.GET)
    public String setUpUserCenter(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return USER_CENTER_VIEW;
    }

    /**
     * 注册视图提交表单
     * 
     * @param user 接收表单提交的用户相关参数并封装为模型对象user
     * @param schoolId 接收表单提交的schoolId参数
     * */
    @RequestMapping(value = REGISTER_ACTION, method = RequestMethod.POST)
    public String submitRegister(@ModelAttribute("registUser") User user,
            @RequestParam("schoolId") Integer schoolId) {
        // 获取注册学校信息
        School school = commonService.findSchoolById(schoolId);
        user.setSchool(school);
        try {
            userService.save(user);
        } catch (DBException ex) {
            return REGISTER_VIEW;
        }
        return REGISTER_SUCCESS_VIEW;
    }

    /**
     * 登录视图提交表单
     * */
    @RequestMapping(value = LOGIN_ACTION, method = RequestMethod.POST)
    public String submitLogin(@ModelAttribute(value = "loginUser") User user,
            Model model) {
        // 获取真实用户信息
        User realUser = userService.findByUserName(user.getUserName());
        
        // 若密码正确，则将真实用户信息放入session，并转至主页
        if (realUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("user", realUser);
            System.out.println("登录成功");
            return "redirect:" + HOME_URL;
        } 
        // 若密码错误，返回登陆视图
        else {
            return LOGIN_VIEW;
        }
    }
}
