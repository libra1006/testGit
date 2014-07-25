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

    private static final long serialVersionUID = 7634678581082209265L;

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "parrent_address_id")
    private Address parrentAddress;

    @OneToMany(mappedBy = "school")
    private List<User> childrenUser;

    @OneToMany(mappedBy = "school")
    private List<Permit> permitList;

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

    public List<User> getChildrenUser() {
        return childrenUser;
    }

    public void setChildrenUser(List<User> childrenUser) {
        this.childrenUser = childrenUser;
    }

    public List<Permit> getPermitList() {
        return permitList;
    }

    public void setPermitList(List<Permit> permitList) {
        this.permitList = permitList;
    }

}
