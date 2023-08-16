package com.mcg.objects;

import com.mcg.human.Author;

public class Book {
    private static int counter=0;
    int book_Id=-1;
    Author author;
    String name;
    int price;
    Status status;
    int edition;
    String date_of_purchase;

    public Category getCategory() {
        return category;
    }

    Category category;
    public Book(Author author, String name, int price,Category category) {
        counter++;
        this.book_Id = counter;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = Status.AVAILABLE;
        this.edition = 1;
        this.category=category;
    }


    public int getBook_Id() {
        return book_Id;
    }

    public Author getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Status getStatus() {
        return status;
    }

    public int getEdition() {
        return edition;
    }

    public String getDate_of_purchase() {
        return date_of_purchase;
    }

    @Override
    public String toString() {
        return "Author: "+this.getAuthor()+" name: "+this.getName()+" "+"Statusu: "+this.getStatus()+" edition "+this.getEdition()+" kategorisi: "+this.getCategory()+" kitapid:  "+this.getBook_Id()+" ";
    }
}
