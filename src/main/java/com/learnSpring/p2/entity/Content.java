package com.learnSpring.p2.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "Content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "doc_id")
    private int docID;
    @Column(name = "response")
    private String response;
    @Column(name = "question")
    private String questions;
    @Column(name = "createdTime")
    private Date created_Time;
    @Column(name = "createdBy")
    private String created_By;
    @Column(name = "modifiedBy")
    private String modified_By;
    @Column(name = "modifiedTime") private Date modified_time;

    public Content() {
    }

    public Content(int docID, String response, String questions, Date created_Time, String created_By, String modified_By, Date modified_time) {
        this.docID = docID;
        this.response = response;
        this.questions = questions;
        this.created_Time = created_Time;
        this.created_By = created_By;
        this.modified_By = modified_By;
        this.modified_time = modified_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocID() {
        return docID;
    }

    public void setDocID(int docID) {
        this.docID = docID;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public Date getCreated_Time() {
        return created_Time;
    }

    public void setCreated_Time(Date created_Time) {
        this.created_Time = created_Time;
    }

    public String getCreated_By() {
        return created_By;
    }

    public void setCreated_By(String created_By) {
        this.created_By = created_By;
    }

    public String getModified_By() {
        return modified_By;
    }

    public void setModified_By(String modified_By) {
        this.modified_By = modified_By;
    }

    public Date getModified_time() {
        return modified_time;
    }

    public void setModified_time(Date modified_time) {
        this.modified_time = modified_time;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", docID=" + docID +
                ", response='" + response + '\'' +
                ", questions='" + questions + '\'' +
                ", created_Time=" + created_Time +
                ", created_By='" + created_By + '\'' +
                ", modified_By='" + modified_By + '\'' +
                ", modified_time=" + modified_time +
                '}';
    }
}
