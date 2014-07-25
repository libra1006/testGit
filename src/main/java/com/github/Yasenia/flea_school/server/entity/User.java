package com.github.Yasenia.flea_school.server.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "[user]")
public class User implements Serializable {

    private static final long serialVersionUID = -4131451760158797093L;

    @Id
    private String id;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private int sex;

    @Column(name = "birth_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    @Column(name = "register_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "qq")
    private String qq;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "location")
    private String location;

    @Column(name = "zip")
    private String zip;

    @Column(name = "point")
    private String point;

    @Column(name = "icon")
    private String icon;

    @OneToMany(mappedBy = "focusUser")
    private List<FocusUser> UserListAsFocus;

    @OneToMany(mappedBy = "fansUser")
    private List<FocusUser> UserListAsFans;

    @OneToMany(mappedBy = "collectUser")
    private List<CollectGoods> collectListAsCollecter;

    @OneToMany(mappedBy = "user")
    private List<Permit> permitList;
    
    @OneToMany(mappedBy = "seller")
    private List<Goods> goodsListAsSeller;
    
    @OneToMany(mappedBy = "buyer")
    private List<Goods> goodsListAsBuyer;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<FocusUser> getUserListAsFocus() {
        return UserListAsFocus;
    }

    public void setUserListAsFocus(List<FocusUser> userListAsFocus) {
        UserListAsFocus = userListAsFocus;
    }

    public List<FocusUser> getUserListAsFans() {
        return UserListAsFans;
    }

    public void setUserListAsFans(List<FocusUser> userListAsFans) {
        UserListAsFans = userListAsFans;
    }

    public List<CollectGoods> getCollectListAsCollecter() {
        return collectListAsCollecter;
    }

    public void setCollectListAsCollecter(
            List<CollectGoods> collectListAsCollecter) {
        this.collectListAsCollecter = collectListAsCollecter;
    }

    public List<Permit> getPermitList() {
        return permitList;
    }

    public void setPermitList(List<Permit> permitList) {
        this.permitList = permitList;
    }

    public List<Goods> getGoodsListAsSeller() {
        return goodsListAsSeller;
    }

    public void setGoodsListAsSeller(List<Goods> goodsListAsSeller) {
        this.goodsListAsSeller = goodsListAsSeller;
    }

    public List<Goods> getGoodsListAsBuyer() {
        return goodsListAsBuyer;
    }

    public void setGoodsListAsBuyer(List<Goods> goodsListAsBuyer) {
        this.goodsListAsBuyer = goodsListAsBuyer;
    }

}
