package com.learnSpring.p2.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Physician")
public class Physician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "active_Flag")
    private boolean activeFlag;
    @Column(name = "Created_time")
    private Date createdTime;


    public Physician() {
    }

    public Physician(String name, boolean activeFlag, Date dateTime) {
        this.name = name;
        this.activeFlag = activeFlag;
        this.createdTime = createdTime;
    }

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

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        createdTime =new Timestamp(Calendar.getInstance().getTimeInMillis());
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Physician{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", activeFlag=" + activeFlag +
                ", dateTime=" + createdTime +
                '}';
    }




}
