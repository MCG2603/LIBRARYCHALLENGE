package com.mcg.human;


import java.util.List;
import com.mcg.objects.Book;
public interface Search {
    public List<Book> searchByName(String name);
    public List<Book> searchById(int id);
    public List<Book> searchByAuthor(String authorName);
    public void holdBook(Book book);
    public void leaveBook(Book book);

    int budget=100;
     int numberHoldBook=0;


}
