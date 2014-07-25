package com.github.Yasenia.flea_school.server.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "goods")
public class Goods implements Serializable {

    private static final long serialVersionUID = 2538896066711041648L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private double price;

    @ManyToOne
    @JoinColumn(name = "goods_type_id")
    private GoodsType goodsType;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @Column(name = "description")
    private String description;

    @Column(name = "picture")
    private String picture;

    @Column(name = "state")
    private int state;

    @Column(name = "release_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date releaseDate;

    @Column(name = "alter_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date alterDate;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @Column(name = "seller_comment")
    private String sellerComment;

    @Column(name = "buyer_comment")
    private String buyerComment;

    @Column(name = "seller_comment_grade")
    private int sellerCommentGrade;

    @Column(name = "buyer_comment_grade")
    private int buyerCommentGrade;

    @OneToMany(mappedBy = "collectedGoods")
    private List<CollectGoods> collectListAsCollected;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getAlterDate() {
        return alterDate;
    }

    public void setAlterDate(Date alterDate) {
        this.alterDate = alterDate;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public String getSellerComment() {
        return sellerComment;
    }

    public void setSellerComment(String sellerComment) {
        this.sellerComment = sellerComment;
    }

    public String getBuyerComment() {
        return buyerComment;
    }

    public void setBuyerComment(String buyerComment) {
        this.buyerComment = buyerComment;
    }

    public int getSellerCommentGrade() {
        return sellerCommentGrade;
    }

    public void setSellerCommentGrade(int sellerCommentGrade) {
        this.sellerCommentGrade = sellerCommentGrade;
    }

    public int getBuyerCommentGrade() {
        return buyerCommentGrade;
    }

    public void setBuyerCommentGrade(int buyerCommentGrade) {
        this.buyerCommentGrade = buyerCommentGrade;
    }

    public List<CollectGoods> getCollectListAsCollected() {
        return collectListAsCollected;
    }

    public void setCollectListAsCollected(
            List<CollectGoods> collectListAsCollected) {
        this.collectListAsCollected = collectListAsCollected;
    }
    
}
