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

    private static final long serialVersionUID = -7033975889555881318L;

    /**
     * 用户Id
     * */
    @Id
    private String id;

    /**
     * 密码，非空
     * */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * 姓名，非空
     * */
    @Column(name = "name", nullable = false)
    private String name = "";

    /**
     * 性别，非空
     * */
    @Column(name = "sex", nullable = false)
    private Integer sex;

    /**
     * 出生日期
     * */
    @Column(name = "birth_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    /**
     * 注册日期，非空
     * */
    @Column(name = "register_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;

    /**
     * 所在学校
     * */
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    /**
     * 联系电话，唯一
     * */
    @Column(name = "telephone", unique = true)
    private String telephone;

    /**
     * 邮箱地址，唯一
     * */
    @Column(name = "email", unique = true)
    private String email;

    /**
     * 所在地
     * */
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    /**
     * 邮编
     * */
    @Column(name = "zip")
    private String zip;

    /**
     * 联系地址
     * */
    @Column(name = "location")
    private String location;

    /**
     * 其它联系方式
     * */
    @Column(name = "contact_information")
    private String contactInformation;

    /**
     * 金币，非空，默认值为0
     * */
    @Column(name = "coin", nullable = false)
    private Integer coin;

    /**
     * 积分，非空，默认值为0
     * */
    @Column(name = "point", nullable = false)
    private Integer point;

    /**
     * 头像图片
     * */
    @Column(name = "icon")
    private String icon;

    /**
     * 出售商品列表
     * */
    @OneToMany(mappedBy = "seller")
    private List<Goods> goodsListAsSeller;

    /**
     * 购买商品列表
     * */
    @OneToMany(mappedBy = "buyer")
    private List<Goods> goodsListAsBuyer;

    /**
     * 粉丝用户列表
     * */
    @OneToMany(mappedBy = "focusUser")
    private List<FocusUser> UserListAsFocus;

    /**
     * 关注用户列表
     * */
    @OneToMany(mappedBy = "fansUser")
    private List<FocusUser> UserListAsFans;

    /**
     * 收藏商品列表
     * */
    @OneToMany(mappedBy = "collectUser")
    private List<CollectGoods> collectListAsCollecter;

    /**
     * 通行证列表
     * */
    @OneToMany(mappedBy = "user")
    private List<Permit> permitList;

    
    /**
     * getter & setter
     * */
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
}
