package com.Clone.LubimyCzytacClone.services;

import com.Clone.LubimyCzytacClone.entity.Book;
import com.Clone.LubimyCzytacClone.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;


    @Test
    void getBookByTitleAndAuthor() {
        Book bookList = setBookForTests();
        when(bookService.getBookByTitleAndAuthor(bookList.getTitle(), bookList.getAuthor())).thenReturn(bookList);

        Book result = bookService.getBookByTitleAndAuthor(bookList.getTitle(), bookList.getAuthor());

        assertEquals(bookList, result);
    }

    @Test
    void getBookByTitleAndAuthorNotExist() {
        Book result = bookService.getBookByTitleAndAuthor("Title", "Author");

        assertNull(result);
    }

    @Test
    void addBook() {
        Book book = setBookForTests();

        boolean addedBook = bookService.addBook(book);

        assertTrue(addedBook);

        verify(bookRepository).save(book);
    }

    @Test
    void updateBook() {
        Book bookToUpdate = new Book(
                1L,
                "The Way of Kings",
                2001,
                "B.Sanderson");

        bookService.updateBook(bookToUpdate);

        verify(bookRepository).updateBook(bookToUpdate.getId(),
                bookToUpdate.getTitle(),
                bookToUpdate.getReleaseYear(),
                bookToUpdate.getAuthor());
    }

    private Book setBookForTests() {

        return new Book(
                1L,
                "The Way of Kings",
                2001,
                "Brandon Sanderson"
        );
    }
}