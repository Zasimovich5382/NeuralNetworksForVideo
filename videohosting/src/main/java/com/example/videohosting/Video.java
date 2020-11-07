package com.example.videohosting;

public class Video {
    private String name;
    private String id;
    //private String url;

    public Video(String name, String id) {
        this.name = name;
        this.id = id;
        //this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /*public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }*/
}
