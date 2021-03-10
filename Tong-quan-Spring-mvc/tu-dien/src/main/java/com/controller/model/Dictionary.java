package com.controller.model;

public class Dictionary {
    private String viet;
    public String engLish;

    public Dictionary(String viet, String engLish) {
        this.viet = viet;
        this.engLish = engLish;
    }

    public Dictionary() {
    }

    public String getViet() {
        return viet;
    }

    public void setViet(String viet) {
        this.viet = viet;
    }

    public String getEngLish() {
        return engLish;
    }

    public void setEngLish(String engLish) {
        this.engLish = engLish;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "viet='" + viet + '\'' +
                ", engLish='" + engLish + '\'' +
                '}';
    }
}
