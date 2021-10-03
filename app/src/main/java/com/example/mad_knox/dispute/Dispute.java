package com.example.mad_knox.dispute;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class Dispute implements Serializable {

    @Exclude
    private String key;
    private String reason;
    private  String experience;



    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }



    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
