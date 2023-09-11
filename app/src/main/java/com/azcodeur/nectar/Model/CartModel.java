package com.azcodeur.nectar.Model;

public class CartModel {
    String img,name, desc, price, number;

    public CartModel() {}

    public CartModel(String img, String name, String desc, String price, String number) {
        this.img = img;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.number = number;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
