package com.company;

public class Book {
     String name;
     int pages;

     public Book(){
         this("Unknown", 0);
     }


    public Book(String name, int pages){
        this.name = name;
        this.pages = pages;

    }

    public String getName(){
         return name;
    }

    public String toString(){
        return name + " " + pages;
    }
}
