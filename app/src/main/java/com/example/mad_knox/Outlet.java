package com.example.mad_knox;

public class Outlet
{
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
}
