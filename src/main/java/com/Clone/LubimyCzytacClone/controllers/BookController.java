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

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok().body(bookService.getAllBooks());
    }

    @PostMapping("/book")
    public ResponseEntity<String> addBook(@RequestBody Book newBook){
        if(bookService.addBook(newBook)){
            return ResponseEntity.ok().body(("Book created successfully"));
        }else {
            return ResponseEntity.badRequest().body("Invalid data: The book data is incorrect");
        }
    }

    @GetMapping("/book")
    public ResponseEntity<Book> getBookByTitleAndAuthor(@RequestParam String title, @RequestParam String author){
        Book getBook = bookService.getBookByTitleAndAuthor(title, author);
        if(getBook != null){
            return ResponseEntity.ok().body(getBook);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/book")
    public void removeBook(@RequestParam Long id){
        bookService.removeBook(id);
    }

    @PatchMapping("/book")
    public void updateBook(@RequestBody Book book){bookService.updateBook(book);
    }

}
