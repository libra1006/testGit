package com.github.Yasenia.flea_school.server.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "goods_type")
public class GoodsType implements Serializable {

    private static final long serialVersionUID = -1390755147077859415L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "parrent_goods_type_id")
    private GoodsType parrentGoodsType;

    @OneToMany(mappedBy = "parrentGoodsType")
    private List<GoodsType> childrenGoodsType;

    @OneToMany(mappedBy = "goodsType")
    private List<Goods> childrenGoods;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GoodsType getParrentGoodsType() {
        return parrentGoodsType;
    }

    public void setParrentGoodsType(GoodsType parrentGoodsType) {
        this.parrentGoodsType = parrentGoodsType;
    }

    public List<GoodsType> getChildrenGoodsType() {
        return childrenGoodsType;
    }

    public void setChildrenGoodsType(List<GoodsType> childrenGoodsType) {
        this.childrenGoodsType = childrenGoodsType;
    }

    public List<Goods> getChildrenGoods() {
        return childrenGoods;
    }

    public void setChildrenGoods(List<Goods> childrenGoods) {
        this.childrenGoods = childrenGoods;
    }

}
