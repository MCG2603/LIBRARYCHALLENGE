package com.mcg.objects;

import com.mcg.human.Author;
import com.mcg.human.Professor;
import com.mcg.human.Student;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        Librarian librarian =Librarian.getLibrarian();
        Librarian librarian2 =Librarian.getLibrarian();

        Author MCG = new Author("MCG");
        Author MCG2 = new Author("MCG2");
        Book algebra = new Book(MCG, "mat1", 130, Category.MATH);
        Book fizik = new Book(MCG, "fizik", 130, Category.PHYSICS);
        librarian.newBook(algebra);
        librarian.newBook(fizik);
        librarian.newBook(new Book(MCG, "fizik", 130, Category.PHYSICS));
        librarian.newBook(new Book(MCG, "bilgisayar", 170, Category.COMPUTER_SCIENCE));
        librarian.newBook(new Book(MCG, "bilgisayar2", 170, Category.COMPUTER_SCIENCE));
        librarian.newBook(new Book(MCG2, "fizik2", 130, Category.PHYSICS));
        librarian.newBook(new Book(MCG, "bilgisayar3", 170, Category.COMPUTER_SCIENCE));
        librarian.newBook(new Book(MCG, "bilgisayar4", 170, Category.COMPUTER_SCIENCE));

        System.out.println(MCG.books);
        System.out.println(Library.books);

        Student student = new Student("Mirac", 350);



        Scanner scanner = new Scanner(System.in);
        System.out.println("Kütüphaneye hoş geldiniz.");
        System.out.println("Öğrenci girişi için 1'i");
        System.out.println("Profesor girişi için 2'i");
        System.out.println("Kütüphaneci girişi için 3'ü");


        System.out.println("Çıkış için 0'ı");
        System.out.println("Tuşlayın lütfen");


        String s = "";

        String myInt = "10";
        while (!(myInt.equals("0"))) {
            myInt = scanner.next();
            int keyid;
            if (myInt.equals("1")) {
                System.out.println("Lütfen id nizi girin");
                myInt = scanner.next();
                keyid = Integer.parseInt(myInt);

                if (Library.persons.containsKey(keyid)) {
                    if (Library.persons.get(keyid) instanceof Student) {
                        s = "Hoş geldin " + Library.persons.get(keyid).getName();
                        System.out.println(s);
                        System.out.println("Kitap aramak için 6'ı");
                        System.out.println("Kitap almak için 7'i");
                        System.out.println("Aldığınız kitabı iade etmek için 8 'i tuşlayın");
                        myInt = scanner.next();
                        if (myInt.equals("6")) {
                            System.out.println("Lütfen bir arama şekli seçiniz:");
                            System.out.println("yazar ile aramak için 9 'u");
                            System.out.println("id ile aramak için 10'u");
                            System.out.println("kitap ismi ile aramak için 11'i tuşlayın");
                            myInt = scanner.next();
                            if (myInt.equals("9")) {
                                System.out.println(Library.books);

                                System.out.println("yazarın ismini girin");


                                String g = scanner.next();

                                System.out.println(((Student) Library.persons.get(keyid)).searchByAuthor(g));

                            }
                            if (myInt.equals("10")) {
                                System.out.println(Library.books);

                                System.out.println("kitabın id sini girin");
                                int t1 = scanner.nextInt();
                                System.out.println(((Student) Library.persons.get(keyid)).searchById(t1));

                            }
                            if (myInt.equals("11")) {
                                System.out.println(Library.books);
                                System.out.println("kitabın ismini girin");
                                String t = scanner.next();
                                System.out.println(((Student) Library.persons.get(keyid)).searchByName(t));

                            }
                        }
                        if (myInt.equals("7")) {
                            System.out.println(Library.books);
                            System.out.println("Lütfen almak istediğiniz kitabın id sini girin");
                            int t1 = scanner.nextInt();

                            if(Library.books.get(t1)==null){
                                System.out.println("Böyle bir kitap yoktur tekrar deneyiniz");

                            }
                            ((Student) Library.persons.get(keyid)).holdBook(Library.books.get(t1));
                            System.out.println(Library.users.get(((Student) Library.persons.get(keyid))));


                        }
                        if (myInt.equals("8")) {
                            System.out.println(Library.users.get(((Student) Library.persons.get(keyid))));

                            System.out.println("Lütfen geri vermek istediğiniz kitabın id sini girin");



                            int t1 = scanner.nextInt();
                            ((Student) Library.persons.get(keyid)).leaveBook(Library.books.get(t1));
                            System.out.println(Library.users);
                        }


                    } else {
                        System.out.println("Sistemde kayıtlı değilsiniz");
                    }


                } else {
                    System.out.println("Sistemde kayıtlı değilsiniz");
                }

            }

            if (myInt.equals("2")) {
                System.out.println("Lütfen id nizi girin");
                myInt = scanner.next();
                keyid = Integer.parseInt(myInt);

                if (Library.persons.containsKey(keyid)) {
                    if (Library.persons.get(keyid) instanceof Professor) {
                        s = "Hoş geldin " + Library.persons.get(keyid).getName();
                        System.out.println(s);
                        System.out.println("Kitap aramak için 6'ı");
                        System.out.println("Kitap almak için 7'i");
                        System.out.println("Aldığınız kitabı iade etmek için 8 'i tuşlayın");
                        myInt = scanner.next();
                        if (myInt.equals("6")) {
                            System.out.println("Lütfen bir arama şekli seçiniz:");
                            System.out.println("yazar ile aramak için 9 'u");
                            System.out.println("id ile aramak için 10'u");
                            System.out.println("kitap ismi ile aramak için 11'i tuşlayın");
                            myInt = scanner.next();
                            if (myInt.equals("9")) {
                                System.out.println(Library.books);

                                System.out.println("yazarın ismini girin");


                                String g = scanner.next();

                                System.out.println(((Professor) Library.persons.get(keyid)).searchByAuthor(g));

                            }
                            if (myInt.equals("10")) {
                                System.out.println(Library.books);

                                System.out.println("kitabın id sini girin");
                                int t1 = scanner.nextInt();
                                System.out.println(((Professor) Library.persons.get(keyid)).searchById(t1));

                            }
                            if (myInt.equals("11")) {
                                System.out.println(Library.books);
                                System.out.println("kitabın ismini girin");
                                String t = scanner.next();
                                System.out.println(((Professor) Library.persons.get(keyid)).searchByName(t));

                            }
                        }
                        if (myInt.equals("7")) {
                            System.out.println(Library.books);
                            System.out.println("Lütfen almak istediğiniz kitabın id sini girin");
                            int t1 = scanner.nextInt();

                            if(Library.books.get(t1)==null){
                                System.out.println("Böyle bir kitap yoktur tekrar deneyiniz");

                            }
                            ((Professor) Library.persons.get(keyid)).holdBook(Library.books.get(t1));
                            System.out.println(Library.users.get(((Professor) Library.persons.get(keyid))));


                        }
                        if (myInt.equals("8")) {
                            System.out.println(Library.users.get( ((Professor) Library.persons.get(keyid))));

                            System.out.println("Lütfen geri vermek istediğiniz kitabın id sini girin");



                            int t1 = scanner.nextInt();
                            ((Professor) Library.persons.get(keyid)).leaveBook(Library.books.get(t1));
                            System.out.println(Library.users);
                        }


                    } else {
                        System.out.println("Sistemde kayıtlı değilsiniz");
                    }


                } else {
                    System.out.println("Sistemde kayıtlı değilsiniz");
                }

            }



            if (myInt.equals("3")) {
                System.out.println("Lütfen id nizi girin");
                myInt = scanner.next();
                keyid = Integer.parseInt(myInt);

                if (Library.persons.containsKey(keyid)) {
                    if (Library.persons.get(keyid) instanceof Librarian) {
                        s = "Hoş geldin " + Library.persons.get(keyid).getName();
                        System.out.println(s);
                        System.out.println("Yeni kitap eklemek için 12");
                        System.out.println("Kitap silmek için 13");
                        System.out.println("kitap güncellemek için 14");
                        System.out.println("bir yazarın tüm kitaplarını silmek için 15");
                        System.out.println("bir kategorinin tüm kitaplarını silmek için 16");

                        myInt = scanner.next();
                        if (myInt.equals("12")) {
                            System.out.println(Library.books);


                            System.out.println("Lütfen kitap bilgilerini girin");
                            System.out.println("Kitabın yazarını girin:");
                            String s1 = scanner.next();
                            System.out.println("Kitabın ismini girin:");
                            String s2 = scanner.next();
                            System.out.println("Kitabın fiyatını girin:");
                            int s3 = scanner.nextInt();
                            System.out.println("Kitabın kategorisini girin:");
                            String s4 = scanner.next().toUpperCase();
                            switch (s4){

                                case  "PHYSICS":
                                    ((Librarian)Library.persons.get(keyid)).newBook(new Book(new Author(s1),s2,s3,Category.PHYSICS));
                                    break;
                                case  "COMPUTER_SCIENCE":
                                    ((Librarian)Library.persons.get(keyid)).newBook(new Book(new Author(s1),s2,s3,Category.COMPUTER_SCIENCE));
                                    break;

                                case  "CHEMISTRY":
                                    ((Librarian)Library.persons.get(keyid)).newBook(new Book(new Author(s1),s2,s3,Category.CHEMISTRY));

                                    break;
                                case  "ECONOMICS":
                                    ((Librarian)Library.persons.get(keyid)).newBook(new Book(new Author(s1),s2,s3,Category.ECONOMICS));
                                    break;

                                case  "NOVEL":
                                    ((Librarian)Library.persons.get(keyid)).newBook(new Book(new Author(s1),s2,s3,Category.NOVEL));
                                    break;

                                default:
                                    ((Librarian)Library.persons.get(keyid)).newBook(new Book(new Author(s1),s2,s3,Category.MATH));
                                    break;


                            }
                            System.out.println(Library.books);


                        }
                        if (myInt.equals("13")) {
                            System.out.println(Library.books);

                            System.out.println("Lütfen silmek istediğiniz kitabın id sini girin");
                            int s11=scanner.nextInt();
                            ((Librarian)Library.persons.get(keyid)).deleteBook(s11);
                            System.out.println(Library.books);

                        }
                        if (myInt.equals("14")) {
                            System.out.println(Library.books);
                            System.out.println("Lütfen güncellemek istediğiniz kitabın id sini girin");
                            int s11=scanner.nextInt();
                            ((Librarian)Library.persons.get(keyid)).updateBook(s11);

                            System.out.println(Library.books);
                        }

                        if (myInt.equals("15")) {
                            System.out.println(Library.books);
                            System.out.println("Lütfen silmek  istediğiniz kitapların yazarının id sini giriniz");
                            int s11=scanner.nextInt();
                            ((Librarian)Library.persons.get(keyid)).deleteBookByAuthor(((Author)Library.persons.get(s11)));
                            System.out.println(Library.books);

                        }
                        if (myInt.equals("16")) {
                            System.out.println(Library.books);

                            System.out.println("Kitabın kategorisini girin:");
                            String s4 = scanner.next().toUpperCase();
                            switch (s4){

                                case  "PHYSICS":
                                    ((Librarian)Library.persons.get(keyid)).deleteBookByCategory(Category.PHYSICS);
                                    break;
                                case  "COMPUTER_SCIENCE":
                                    ((Librarian)Library.persons.get(keyid)).deleteBookByCategory(Category.COMPUTER_SCIENCE);
                                    break;

                                case  "CHEMISTRY":
                                    ((Librarian)Library.persons.get(keyid)).deleteBookByCategory(Category.CHEMISTRY);

                                    break;
                                case  "ECONOMICS":
                                    ((Librarian)Library.persons.get(keyid)).deleteBookByCategory(Category.ECONOMICS);
                                    break;

                                case  "NOVEL":
                                    ((Librarian)Library.persons.get(keyid)).deleteBookByCategory(Category.NOVEL);
                                    break;

                                case "MATH":
                                    ((Librarian)Library.persons.get(keyid)).deleteBookByCategory(Category.MATH);
                                    break;
                                default:
                                    System.out.println("Böyle bir kategori yoktur");


                            }
                            System.out.println(Library.books);

                        }


                        }

                    else {
                        System.out.println("Sistemde kayıtlı değilsiniz");
                    }
                    }




                else {
                    System.out.println("Sistemde kayıtlı değilsiniz");
                }

            }


        }
        scanner.close();
    }
}
