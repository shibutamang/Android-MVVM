package com.shibu.boilerplateapp.Model;

public class Product {
    private String productName;
    private String price;
    private String oldPrice;
    private int productImaage;


    public Product(String productName, String price, String oldPrice, int productImaage) {
        this.productName = productName;
        this.price = price;
        this.oldPrice = oldPrice;
        this.productImaage = productImaage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public int getProductImaage() {
        return productImaage;
    }

    public void setProductImaage(int productImaage) {
        this.productImaage = productImaage;
    }
}
