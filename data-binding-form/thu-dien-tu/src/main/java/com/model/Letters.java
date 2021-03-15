package com.model;

public class Letters {
    private String languages;
    private String size;
    private boolean spams;
    private String signature;


    public Letters(){}

    public Letters(String languages, String size, boolean spams, String signature) {
        this.languages = languages;
        this.size = size;
        this.spams = spams;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isSpams() {
        return spams;
    }

    public void setSpams(boolean spams) {
        this.spams = spams;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Letters{" +
                "languages='" + languages + '\'' +
                ", size='" + size + '\'' +
                ", spams='" + spams + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
