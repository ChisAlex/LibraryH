package com.company;

public class Album extends Book {
    private String quality;

    public Album(String name, Integer pages, String quality){
        super(name, pages);
        this.quality = quality;
    }

    public String toString(){
        return "The name of the album is: " + name + ", " + "it has " + pages + " pages" + " with " + quality + " grade paper quality";
    }
}
