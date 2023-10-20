package com.Clone.LubimyCzytacClone.services;

import com.Clone.LubimyCzytacClone.entity.Book;
import com.Clone.LubimyCzytacClone.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookInfo(String title, String author){

        return bookRepository.getBookByTitleAndAuthor(title, author);

    }
    public void addBook(Book newBook){

        //String author = newBook.get

        bookRepository.save(newBook);
    }

    public void removeBook(Long id){
        bookRepository.deleteById(id);
    }

    public void updateBook(Book bookToUpdate){
        //TODO update Book
    }

    public Boolean checkIfBookDataNotNull(Book book) {

        if(book.getTitle() == null || book.getTitle().isEmpty() || book.getAuthor() == null || book.getAuthor().isEmpty()){
            return false;
        }
        return true;
    }
}
