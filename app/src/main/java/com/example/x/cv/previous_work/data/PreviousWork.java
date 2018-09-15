package com.example.x.cv.previous_work.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "previous-work-table")
public class PreviousWork {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String company;
    private String role;
    private String from;
    private String to;

    @Ignore
    public PreviousWork(String company, String role, String from, String to) {
        this.company = company;
        this.role = role;
        this.from = from;
        this.to = to;
    }

    public PreviousWork(int id, String company, String role, String from, String to) {
        this.id = id;
        this.company = company;
        this.role = role;
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
