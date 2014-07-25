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
@Table(name = "focus_user")
public class FocusUser implements Serializable {

    private static final long serialVersionUID = -1984452621834197015L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "fans_user")
    private User fansUser;

    @ManyToOne
    @JoinColumn(name = "focus_user")
    private User focusUser;

    @Column(name = "focus_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date focusDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getFansUser() {
        return fansUser;
    }

    public void setFansUser(User fansUser) {
        this.fansUser = fansUser;
    }

    public User getFocusUser() {
        return focusUser;
    }

    public void setFocusUser(User focusUser) {
        this.focusUser = focusUser;
    }

    public Date getFocusDate() {
        return focusDate;
    }

    public void setFocusDate(Date focusDate) {
        this.focusDate = focusDate;
    }

}
