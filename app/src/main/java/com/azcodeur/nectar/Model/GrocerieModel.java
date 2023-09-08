package com.azcodeur.nectar.Model;

public class GrocerieModel {
    String title, pic, name;

    public GrocerieModel() {}

    public GrocerieModel(String pic, String name, String title) {
        this.pic = pic;
        this.name = name;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
