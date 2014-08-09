package com.github.Yasenia.flea_school.server.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "school")
public class School implements Serializable {

	private static final long serialVersionUID = -7045363324548418044L;

	/**
     * 学校Id
     * */
    @Id
    private Integer id;

    /**
     * 学校名，非空
     * */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 父级地区
     * */
    @ManyToOne
    @JoinColumn(name = "parrent_location_id")
    private Location parrentLocation;

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

    public Location getParrentLocation() {
        return parrentLocation;
    }

    public void setParrentLocation(Location parrentLocation) {
        this.parrentLocation = parrentLocation;
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
