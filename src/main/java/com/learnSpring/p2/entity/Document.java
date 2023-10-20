package com.learnSpring.p2.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Documents")
public class Document {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "PHY_ID")
    private int phyID;
    @Column(name = "session_key")
    private int sessionKey;
    @Column(name = "source_product_id")
    private int sourceProductID;
    @Column(name = "created_By")
    private String createdBy;
    @Column(name = "created_Time")
    private Date createdTime;
    @Column(name = "modified_By")
    private String modifiedBy;
    @Column(name = "modified_Time")
    private Date modifiedTime;

    public Document(int i, int i1, int i2, String s, Date date) {
    }

    public Document(int phyID, int sessionKey, int sourceProductID, String createdBy, Date createdTime, String modifiedBy, Date modifiedTime) {
        this.phyID = phyID;
        this.sessionKey = sessionKey;
        this.sourceProductID = sourceProductID;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.modifiedBy = modifiedBy;
        this.modifiedTime = modifiedTime;
    }

    public Document() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(int sessionKey) {
        this.sessionKey = sessionKey;
    }

    public int getSourceProductID() {
        return sourceProductID;
    }

    public void setSourceProductID(int sourceProductID) {
        this.sourceProductID = sourceProductID;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public int getPhyID() {
        return phyID;
    }

    public void setPhyID(int phyID) {
        this.phyID = phyID;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", phyID=" + phyID +
                ", sessionKey=" + sessionKey +
                ", sourceProductID=" + sourceProductID +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
