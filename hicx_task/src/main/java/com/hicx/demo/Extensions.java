package com.hicx.demo;

public enum Extensions {
    PLAIN_TEXT(".txt");

    private String ext;

    Extensions(String ext) {
        this.ext = ext;
    }

    public String getExt() {
        return ext;
    }
}
