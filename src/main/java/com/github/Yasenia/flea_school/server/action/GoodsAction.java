package com.github.Yasenia.flea_school.server.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.Yasenia.flea_school.server.entity.Goods;
import com.github.Yasenia.flea_school.server.entity.GoodsType;
import com.github.Yasenia.flea_school.server.entity.School;
import com.github.Yasenia.flea_school.server.entity.User;
import com.github.Yasenia.flea_school.server.service.ICommonService;
import com.github.Yasenia.flea_school.server.service.IGoodsService;

@Controller
@SessionAttributes(value = { "user" })
public class GoodsAction {

    public static final String RELEASE_GOODS = "releaseGoods";
    public static final String RELEASE_SUCCESS = "releaseSuccess";

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private ICommonService commonService;

    @RequestMapping(value = { RELEASE_GOODS }, method = RequestMethod.GET)
    public String setUpReleaseGoods() {
        return RELEASE_GOODS;
    }

    @RequestMapping(value = { RELEASE_GOODS }, method = RequestMethod.POST)
    public String submitReleaseGoods(@ModelAttribute("goods") Goods goods,
            @ModelAttribute("user") User user,
            @RequestParam("schoolId") Integer schoolId,
            @RequestParam("goodsTypeId") Integer goodsTypeId,
            Model model) {
        School school = commonService.findSchoolById(schoolId);
        GoodsType goodsType = commonService.findGoodsTypeById(goodsTypeId);
        
        goods.setSchool(school);
        goods.setGoodsType(goodsType);
        goods.setSeller(user);
        goodsService.save(goods);
        return RELEASE_SUCCESS;
    }
}
