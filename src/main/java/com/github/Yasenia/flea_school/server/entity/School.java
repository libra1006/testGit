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
@Table(name = "school")
public class School implements Serializable {

    private static final long serialVersionUID = -8407789524777146923L;

    /**
     * 学校Id，自动生成
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 学校名，非空
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
     * 用户列表
     * */
    @OneToMany(mappedBy = "school")
    private List<User> userList;

    /**
     * 通行证列表
     * */
    @OneToMany(mappedBy = "school")
    private List<Permit> permitList;

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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Permit> getPermitList() {
        return permitList;
    }

    public void setPermitList(List<Permit> permitList) {
        this.permitList = permitList;
    }

}
