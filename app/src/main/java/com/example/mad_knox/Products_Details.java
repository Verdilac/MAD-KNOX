package com.example.mad_knox;

public class Products_Details {

    // Columns of Product table in db
    private String Product_Name;
    private String Product_Desc;
    private Integer Product_Price;
    private String Product_Location;

    // Default Constructor
    public Products_Details() {}


    // Getters and Setters
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
}
