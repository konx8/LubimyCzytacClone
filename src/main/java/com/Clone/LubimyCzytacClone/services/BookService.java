package com.Clone.LubimyCzytacClone.services;

import com.Clone.LubimyCzytacClone.entity.Book;
import com.Clone.LubimyCzytacClone.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookInfo(String title, String author){
        if(checkInputParameters(title, author)){
            bookRepository.getBookByTitleAndAuthor(title, author);
        }
        return null;
    }

    public boolean addBook(Book newBook){

        //TODO check id book already exist
        if(checkInputBookData(newBook)){
            bookRepository.save(newBook);
            return true;
        }else {
            return false;
        }

    }

    public void removeBook(Long id){
        bookRepository.deleteById(id);
    }

    public void updateBook(Book bookToUpdate){
        //TODO update Book
    }

    public Boolean checkInputBookData(Book book) {
        return book.getTitle() != null && !book.getTitle().isEmpty() && book.getAuthor() != null && !book.getAuthor().isEmpty();
    }

    private boolean checkInputParameters(String firstParam, String secondParam){
        return firstParam != null && !firstParam.isEmpty() && secondParam != null && !secondParam.isEmpty();
    }
}
