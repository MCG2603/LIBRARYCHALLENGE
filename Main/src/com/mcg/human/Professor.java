package com.mcg.human;

import com.mcg.objects.Book;
import com.mcg.objects.Librarian;
import com.mcg.objects.Library;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Person implements Search {
    public int numberHoldBook;
    public int budget;
    public  List<Book> list;

    public Professor(String name,int budget) {
        super(name);
        this.budget=budget;
    }


    public List<Book> searchByName(String name){
        if(list!=null){list.clear();}

        for(Book b:Library.books.values()){
            if(b.getName().equals(name)){

                if(list==null) {
                    list=new ArrayList<Book>();
                    list.add(b);
                }
                else{

                    list.add(b);

                }            }
        }
        return list;
    }


    public  List<Book> searchById(int id){
        if(list!=null){list.clear();}

        for(int b:Library.books.keySet()){
            if(b==id){
                if(list==null) {
                    list=new ArrayList<Book>();
                    list.add(Library.books.get(id));
                }
                else{

                    list.add(Library.books.get(id));

                }
            }
        }
        return list;
    };
    public List<Book> searchByAuthor(String authorName){
        if(list!=null){list.clear();}
        for(Book b:Library.books.values()){
            if(b.getAuthor().getName().equals(authorName)){
                if(list==null) {
                    list=new ArrayList<Book>();
                    list.add(b);
                }
                else{

                    list.add(b);

                }
            }
        }
        return list;
    }
    public void holdBook(Book book){
        Librarian.tryHoldBook(book,this);

    }
    public void leaveBook(Book book){
        Librarian.leaveBook(book,this);

    }


}
