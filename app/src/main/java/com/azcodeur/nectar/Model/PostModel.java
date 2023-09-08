package com.azcodeur.nectar.Model;

public class PostModel {
    String imgUrl, title, description, price;

    public PostModel() {}

    public PostModel(String imgUrl, String title, String description, String price) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
