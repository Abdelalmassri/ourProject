package com.abdel.mijnproject.data.entities;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity (tableName = "users" , indices = { @Index(value = "emailId",unique = true)})
public class User {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private String dob;

    private String emailId;

    private String insertnewusers;
    private String access_key;

    public String getAccess_key() {
        return access_key;
    }

    public void setAccess_key(String access_key) {
        this.access_key = access_key;
    }


    public String getInsertnewusers() {
        return insertnewusers;
    }

    public void setInsertnewusers(String insertnewusers) {
        this.insertnewusers = insertnewusers;
    }

    private String password;

    public User() {
    }

    public User(String name, String dob, String emailId, String password) {
        this.name = name;
        this.dob = dob;
        this.emailId = emailId;
        this.password = password;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
