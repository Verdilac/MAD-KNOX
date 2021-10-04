package com.example.mad_knox;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class Outlet implements Serializable
{


    @Exclude
    private String key;
    private String name;
    private String category;
    private String description;
    private String location;
    public Outlet(){}
    public Outlet(String name, String category, String description, String location) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
