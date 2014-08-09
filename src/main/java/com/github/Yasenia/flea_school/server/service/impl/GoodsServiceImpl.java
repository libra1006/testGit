package com.github.Yasenia.flea_school.server.service.impl;

import org.springframework.stereotype.Service;

import com.github.Yasenia.flea_school.server.entity.Goods;
import com.github.Yasenia.flea_school.server.service.IGoodsService;


@Service("goodsService")
public class GoodsServiceImpl implements IGoodsService {

    @Override
    public void save(Goods goods) {
        System.out.println("============商品正在存储=============");
        System.out.println("id: " + goods.getId());
        System.out.println("name: " + goods.getName());
        System.out.println("price: " + goods.getPrice());
        System.out.println("description: " + goods.getDescription());
        System.out.println("============商品存储结束=============");
    }
}
