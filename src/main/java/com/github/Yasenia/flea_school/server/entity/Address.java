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
@Table(name = "address")
public class Address implements Serializable {

    private static final long serialVersionUID = -7333327005968513803L;

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "parrent_address_id")
    private Address parrentAddress;

    @OneToMany(mappedBy = "parrentAddress")
    private List<Address> childrenAddress;

    @OneToMany(mappedBy = "parrentAddress")
    private List<School> childrenSchool;

    @OneToMany(mappedBy = "address")
    private List<User> childrenUser;

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

    public List<User> getChildrenUser() {
        return childrenUser;
    }

    public void setChildrenUser(List<User> childrenUser) {
        this.childrenUser = childrenUser;
    }

}
