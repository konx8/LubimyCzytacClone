package com.Clone.LubimyCzytacClone.controllers;

import com.Clone.LubimyCzytacClone.entity.Book;
import com.Clone.LubimyCzytacClone.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("/book")
    public void addBook(@RequestBody Book newBook){
        bookService.addBook(newBook);
    }

    @GetMapping("/book")
    public ResponseEntity<Book> getBookBy(@RequestBody Book book){
        if(bookService.checkIfBookDataNotNull(book)){
            return ResponseEntity.ok(bookService.getBookInfo(book.getTitle(), book.getAuthor()));
        }
        return ResponseEntity.badRequest().body(book);
    }

}
