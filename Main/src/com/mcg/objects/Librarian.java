package com.mcg.objects;
import com.mcg.human.Author;
import com.mcg.human.Person;
import com.mcg.human.Professor;
import com.mcg.human.Student;
import com.mcg.objects.Book;
import com.mcg.objects.Library;
import com.mcg.objects.Status;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Librarian extends Person {
    public static Librarian getLibrarian() {
        if(librarian==null){
            librarian=new Librarian("Ahmet");
        }

            return librarian;


    }

    private static Librarian librarian;
    private Librarian(String name) {
        super(name);
    }
    public static List<Book> list;

    public static void tryHoldBook(Book book,Person person){
        if((person instanceof Student)){
            if(((Student)person).numberHoldBook<5 && ((Student)person).budget>book.getPrice() && Library.books.containsValue(book) && book.getStatus()== Status.AVAILABLE){
                book.status=Status.ONHOLD;
                if( Library.users.get(person)==null){
                    list=new ArrayList<Book>();
                    list.add(book);

                    Library.users.put(person,list);
                    ((Student)person).budget-=book.getPrice();
                }

             else{
                   list=Library.users.get(person);
                   list.add(book);

                    Library.users.put(person,list);
                    ((Student)person).budget-=book.getPrice();

                }

            }
            else{
                if(((Student)person).numberHoldBook>4){System.out.println("fazla kitabınız var");}
                if(((Student)person).budget<book.getPrice()){System.out.println("bakiyeniz yeterli değil");}
                if(!(Library.books.containsValue(book))){System.out.println("kitap yok");}
                if( book.getStatus()!=Status.AVAILABLE){System.out.println("kitap başkasında");}
            }
        }
        if((person instanceof Professor)){
            if(((Professor)person).numberHoldBook<10 && ((Professor)person).budget>book.getPrice() && Library.books.containsValue(book)&& book.getStatus()== Status.AVAILABLE){
                book.status=Status.ONHOLD;
                if( Library.users.get(person)==null){
                    list=new ArrayList<Book>();
                    list.add(book);
                    Library.users.put(person,list);
                    ((Professor)person).budget-=book.getPrice();
                }

                else{
                    list=Library.users.get(person);
                    list.add(book);
                    Library.users.put(person,list);
                    ((Professor)person).budget-=book.getPrice();
                }

            }
            else{
                if(((Student)person).numberHoldBook>4){System.out.println("fazla kitabınız var");}
                if(((Student)person).budget<book.getPrice()){System.out.println("bakiyeniz yeterli değil");}
                if(!(Library.books.containsValue(book))){System.out.println("kitap yok");}
                if( book.getStatus()!=Status.AVAILABLE){System.out.println("kitap başkasında");}
            }
        }

    }
    public static void leaveBook(Book book,Person person){
        if((person instanceof Student)){
            if( Library.users.containsKey(person) ){
                if(Library.users.get(person).contains(book)){
                    ((Student) person).budget += book.getPrice();
                    book.status = Status.AVAILABLE;
                    list=Library.users.get(person);
                    list.remove(book);
                    Library.users.replace(person,list);
                }
                else{
                    System.out.println("bu kitap sizde değil");
                }
            }
            else{
                System.out.println("bu kitap sizde değil");
            }
        }
        if((person instanceof Professor)){
            if( Library.users.containsKey(person) ){
                if(Library.users.get(person).contains(book)){
                    ((Professor) person).budget += book.getPrice();
                    book.status = Status.AVAILABLE;
                    list=Library.users.get(person);
                    list.remove(book);
                    Library.users.replace(person,list);
                }
                else{
                    System.out.println("bu kitap sizde değil");
                }
            }
            else{
                System.out.println("bu kitap sizde değil");
            }
        }
    }

    public void newBook(Book book) {
        book.author.books=new ArrayList<Book>();
        book.author.books.add(book);
        Library.books.put(book.getBook_Id(), book);
        System.out.println(Library.books);
    }

    public void updateBook(int id) {
        Book updateBook = Library.books.get(id);
        updateBook.edition += 1;
        Library.books.replace(id, updateBook);

    }

    public void deleteBook(int id) {
        Book updateBook = Library.books.get(id);
        updateBook.author.books.remove(updateBook);
        Library.books.remove(id);

    }

    public void deleteBookByCategory(Category category) {
        Map<Integer, Book> books1 = new HashMap<Integer, Book>();
        for (Book b : Library.books.values()) {
            books1.put(b.getBook_Id(), b);
        }
        for (Book b : books1.values()) {

            if (b.getCategory() == category) {
                Library.books.remove(b.getBook_Id());
                b.author.books.remove(b);
            }
        }
    }

    public void deleteBookByAuthor(Author author) {
        Map<Integer, Book> books1 = new HashMap<Integer, Book>();
        for (Book b : Library.books.values()) {
            books1.put(b.getBook_Id(), b);
        }
        for (Book b : books1.values()) {

            if (b.getAuthor() == author) {
                Library.books.remove(b.getBook_Id());
                b.author.books.remove(b);
            }
        }

    }



}
