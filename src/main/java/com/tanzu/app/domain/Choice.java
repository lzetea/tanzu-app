package com.tanzu.app.domain;

public class Choice {

    private final String url;

    private final String name;


    public Choice(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }
}
