package com.example.just_design;

public class Item {

    private String name;
    private int picture;

    public Item(String name, int picture) {
        this.name = name;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = Integer.parseInt(picture);
    }
}
