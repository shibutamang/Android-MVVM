package com.shibu.boilerplateapp.Model;

public class SpecialOffer {

    private String productName;
    private String price;
    private int productImage;

    public SpecialOffer(String name, String price, int image) {
        this.productName = name;
        this.price = price;
        this.productImage = image;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getProductImage() {
        return this.productImage;
    }

    public void setProductImage(int image) {
        this.productImage = image;
    }
}
