package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Library {

    List<Book> books = new ArrayList<>();

    public static void main(String[] args) {

        Library library = new Library();
        Scanner keyboard = new Scanner(System.in);
        String action;

        do{
            displayMenu();
            action = keyboard.nextLine();

            switch (action){
                case "A":
                    System.out.println("Book name= ?");
                    String bookName = keyboard.nextLine();

                    Integer pages = 0;
                    boolean isValidNoOfPages = false;
                    while (!isValidNoOfPages){
                        isValidNoOfPages = true;
                        System.out.println("Number of pages = ?");
                        String nop = keyboard.nextLine();
                        try {
                            pages = Integer.parseInt(nop);
                        }catch(NumberFormatException numberFormatException){
                            isValidNoOfPages = false;
                        }
                    }

                    Book book = new Book();
                    boolean isValidBook = false;
                    while(!isValidBook) {
                        isValidBook = true;
                        System.out.println("N = novel; A = ArtAlbum");
                        String inputType = keyboard.nextLine();
                        if ("N".equals(inputType)) {
                            System.out.println("Novel type = ? ");
                            String type = keyboard.nextLine();
                            book = new Novel(bookName, pages, type);
                        } else if ("A".equals(inputType)) {
                            System.out.println("Art album paper quality = ? ");
                            String paperQuality = keyboard.nextLine();
                            book = new Album(bookName, pages, paperQuality);
                        } else{
                            isValidBook = false;
                        }
                    }

                    library.addBook(book);

                    break;

                case "D":
                    System.out.println("Book name = ?");
                    String bookNameToBeDeleted = keyboard.nextLine();
                    library.deleteBook(bookNameToBeDeleted);
                    break;

                case "L":
                    library.listBooks();
            }
        }while (!"X".equals(action));

    }

    public void addBook(Book book){
        //if(!(book instanceof Novel) || (book instanceof Novel && !((Novel)book).getType().equals("adult"))) {
            this.books.add(book);
        }


    public void deleteBook(String name){
        Book bookToBeDeleted = null;
        for (Book book: books) {
            if(book.getName().equals(name)){
                bookToBeDeleted = book;
                break;
            }
        }

        if(bookToBeDeleted != null){
            books.remove(bookToBeDeleted);
        }
    }

    public void listBooks(){
        for (Book book: books) {
            System.out.println(book.toString());
        }
    }

    static void displayMenu(){
        System.out.println("A = add");
        System.out.println("D = delete");
        System.out.println("L = list");
        System.out.println("X = exit");
        System.out.println("Type your option");
    }

}



                    /*books.add(new Novel("fantasy", "Harry Potter", 540));
        books.add(new Novel("mystery", "LOTR", 220));
        books.add(new Novel("thriller", "Blind", 180));
        books.add(new Novel("crimes", "Seven", 250));
        books.add(new Novel("mystery", "Witcher", 350));


        books.add(new Album(9.0, "Andrei", 220));
        books.add(new Album(5.7, "Mihai", 540));
        books.add(new Album(3.9, "Alvey", 230));
        books.add(new Album(8.9, "Bili", 180));
        books.add(new Album(4.0, "Ray", 250));
        books.add(new Album(7.7, "Donovan", 350));

        // System.out.println(libraryItems);

        for(Book item : books){
            System.out.println(item);
        }

        //libraryItems.remove(0);
        //System.out.println();
        //System.out.println(libraryItems);*/


