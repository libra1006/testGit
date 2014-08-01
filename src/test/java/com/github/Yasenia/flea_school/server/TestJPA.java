package com.github.Yasenia.flea_school.server;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class TestJPA {
    private EntityManagerFactory emf;
    @Before
    public void before() {
        emf = Persistence.createEntityManagerFactory("fleaSchool");
    }
    
    @Test
    public void test() {
    }
}
