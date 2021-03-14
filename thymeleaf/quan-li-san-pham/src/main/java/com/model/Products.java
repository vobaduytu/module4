package com.model;

public class Products {
    private int id;
    private String productName;
    private String description;

    public Products(int id, String productName, String description) {
        this.id = id;
        this.productName = productName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Products(){}
}
