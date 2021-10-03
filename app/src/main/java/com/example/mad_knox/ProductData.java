package com.example.mad_knox;

import com.google.firebase.database.Exclude;

public class ProductData {

    //Key
    @Exclude
    private String key;

    // Columns of Product table in db
    private String Product_Name;
    private String Product_Desc;
    private Integer Product_Price;
    private String Product_Location;
    private String Product_Img;

    // Default Constructor
    public ProductData() {

    }

    // Overloaded Constructor
    public ProductData(String product_Name, String product_Desc, Integer product_Price, String product_Location, String product_Img) {
        Product_Name = product_Name;
        Product_Desc = product_Desc;
        Product_Price = product_Price;
        Product_Location = product_Location;
        Product_Img = product_Img;
    }


    // Getters and Setters

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public String getProduct_Desc() {
        return Product_Desc;
    }

    public void setProduct_Desc(String product_Desc) {
        Product_Desc = product_Desc;
    }

    public Integer getProduct_Price() {
        return Product_Price;
    }

    public void setProduct_Price(Integer product_Price) {
        Product_Price = product_Price;
    }

    public String getProduct_Location() {
        return Product_Location;
    }

    public void setProduct_Location(String product_Location) {
        Product_Location = product_Location;
    }

    public String getProduct_Img() {
        return Product_Img;
    }

    public void setProduct_Img(String product_Img) {
        Product_Img = product_Img;
    }
}
