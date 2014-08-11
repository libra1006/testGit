package com.github.Yasenia.flea_school.server.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.github.Yasenia.flea_school.server.dao.IGoodsDAO;
import com.github.Yasenia.flea_school.server.entity.Goods;
import com.github.Yasenia.flea_school.server.entity.School;

@Repository("goodsDAO")
public class GoodsDAOImpl implements IGoodsDAO {

    @PersistenceContext
    private EntityManager em;
    
    
    @Override
    public void save(Goods goods) {
        em.persist(goods);
    }

    @Override
    public List<Goods> findGoodsBySchoolId(Integer schoolId) {
        School school = em.find(School.class, schoolId);
        List<Goods> result = school.getGoodsList();
        return result;
    }
}
