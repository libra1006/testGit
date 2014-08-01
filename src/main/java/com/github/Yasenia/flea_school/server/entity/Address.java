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
@Table(name = "address")
public class Address implements Serializable {

    private static final long serialVersionUID = -2667073197898222262L;

    /**
     * 地址Id，自动生成
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 地址名，非空
     * */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 父级地址
     * */
    @ManyToOne
    @JoinColumn(name = "parrent_address_id")
    private Address parrentAddress;

    /**
     * 子级地址
     * */
    @OneToMany(mappedBy = "parrentAddress")
    private List<Address> childrenAddress;

    /**
     * 子级学校
     * */
    @OneToMany(mappedBy = "parrentAddress")
    private List<School> childrenSchool;

    /**
     * 用户列表
     * */
    @OneToMany(mappedBy = "address")
    private List<User> userList;

    /**
     * getter & setter
     * */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getParrentAddress() {
        return parrentAddress;
    }

    public void setParrentAddress(Address parrentAddress) {
        this.parrentAddress = parrentAddress;
    }

    public List<Address> getChildrenAddress() {
        return childrenAddress;
    }

    public void setChildrenAddress(List<Address> childrenAddress) {
        this.childrenAddress = childrenAddress;
    }

    public List<School> getChildrenSchool() {
        return childrenSchool;
    }

    public void setChildrenSchool(List<School> childrenSchool) {
        this.childrenSchool = childrenSchool;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

}
