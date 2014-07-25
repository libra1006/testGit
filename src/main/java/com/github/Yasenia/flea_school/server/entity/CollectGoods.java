package com.github.Yasenia.flea_school.server.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "collect_goods")
public class CollectGoods implements Serializable {

    private static final long serialVersionUID = -5474259883485716549L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "collect_user")
    private User collectUser;

    @ManyToOne
    @JoinColumn(name = "collected_goods")
    private Goods collectedGoods;

    @Column(name = "collect_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date collectDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCollectUser() {
        return collectUser;
    }

    public void setCollectUser(User collectUser) {
        this.collectUser = collectUser;
    }

    public Goods getCollectedGoods() {
        return collectedGoods;
    }

    public void setCollectedGoods(Goods collectedGoods) {
        this.collectedGoods = collectedGoods;
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }

}
