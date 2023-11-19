package com.Clone.LubimyCzytacClone;

import com.Clone.LubimyCzytacClone.entity.Book;
import com.Clone.LubimyCzytacClone.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FillDataBase implements CommandLineRunner{

    @Autowired
    BookService bookService;

    public void setTestBooks(){

        Book book1 = new Book("Mistborn", 2006, "Brandon Sanderson");
        Book book2 = new Book("The Way of Kings", 2010, "Brandon Sanderson");
        Book book3 = new Book("The Blade Itself", 2008, "Joe Abercrombie");
        Book book4 = new Book("The Heroes", 2012, "Joe Abercrombie");
        Book book5 = new Book("The Dragonbone Chair ", 1993, "Tad Williams");

        bookService.addBook(book1);
        bookService.addBook(book2);
        bookService.addBook(book3);
        bookService.addBook(book4);
        bookService.addBook(book5);

    }

    @Override
    public void run(String... args) throws Exception {
        setTestBooks();
    }
}
