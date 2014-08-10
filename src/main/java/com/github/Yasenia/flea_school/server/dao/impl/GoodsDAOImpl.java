package com.github.Yasenia.flea_school.server.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.github.Yasenia.flea_school.server.dao.IGoodsDAO;
import com.github.Yasenia.flea_school.server.entity.Goods;

@Repository("goodsDAO")
public class GoodsDAOImpl implements IGoodsDAO {

    @PersistenceContext
    private EntityManager em;
    
    
    @Override
    public void save(Goods goods) {
        em.persist(goods);
    }
}
