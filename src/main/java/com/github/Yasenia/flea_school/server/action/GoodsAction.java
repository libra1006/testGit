package com.github.Yasenia.flea_school.server.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.Yasenia.flea_school.server.entity.Goods;
import com.github.Yasenia.flea_school.server.service.IGoodsService;

@Controller
public class GoodsAction {
    
    public static final String RELEASE_GOODS = "releaseGoods";
    
    @Autowired
    private IGoodsService goodsService;
    
    @RequestMapping(value = {RELEASE_GOODS}, method = RequestMethod.GET)
    public String setUpReleaseGoods() {
        return RELEASE_GOODS;
    }
    
    
    @RequestMapping(value = {RELEASE_GOODS}, method = RequestMethod.POST)
    public String submitReleaseGoods(
            @ModelAttribute("goods") Goods goods
            ) {
        
        goodsService.save(goods);
        return RELEASE_GOODS;
    }
}
