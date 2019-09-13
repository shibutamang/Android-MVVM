package com.shibu.boilerplateapp.Model;

public class TopCategory {
    private String category;
    private int catImage;

    public TopCategory(String category, int catImage) {
        this.category = category;
        this.catImage = catImage;
    }

    public String getCategory(){
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCatImage() {
        return this.catImage;
    }

    public void setCatImage(int catImage) {
        this.catImage = catImage;
    }
}
