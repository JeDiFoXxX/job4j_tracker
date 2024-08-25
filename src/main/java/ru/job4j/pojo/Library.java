package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book classicLiterature = new Book("War and peace", 1300);
        Book scientificLiterature = new Book("The Anatomy of delusions", 578);
        Book fantasticLiterature = new Book("Metro 2034", 384);
        Book cleanCode = new Book("Clean code", 1);
        Book[] book = new Book[4];
        book[0] = classicLiterature;
        book[1] = scientificLiterature;
        book[2] = fantasticLiterature;
        book[3] = cleanCode;
        for (int index = 0; index < book.length; index++) {
            System.out.println(book[index].getName() + " - " + book[index].getPage());
        }
        System.out.println();

        Book storage = book[0];
        book[0] = book[3];
        book[3] = storage;
        for (int index = 0; index < book.length; index++) {
            System.out.println(book[index].getName() + " - " + book[index].getPage());
        }
        System.out.println();

        for (int index = 0; index < book.length; index++) {
            if (book[index].getName().equals("Clean code")) {
                System.out.println(book[index].getName() + " - " + book[index].getPage());
            }
        }
    }
}
