package com.example.mad_knox;

public class ProductListing {
    private String product_name;
    private String product_category;
    private String product_price;
    private String product_quantity;
    private String product_description;
    private String product_image_link;

    public ProductListing(String product_name, String product_category, String product_price, String product_quantity, String product_description, String product_image_link) {
        this.product_name = product_name;
        this.product_category = product_category;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
        this.product_description = product_description;
        this.product_image_link = product_image_link;
    }
}
