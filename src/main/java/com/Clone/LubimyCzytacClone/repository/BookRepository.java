package com.Clone.LubimyCzytacClone.repository;

import com.Clone.LubimyCzytacClone.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("SELECT b FROM Book b WHERE b.title = :title AND b.author = :author")
    Book getBookByTitleAndAuthor(@Param("title") String title, @Param("author") String author);

    @Modifying
    @Query("UPDATE Book b SET b.title = :title, b.releaseYear = :releaseYear, b.author = :author WHERE b.id = :id")
    void updateBook(@Param("id") Long id, @Param("title") String title, @Param("releaseYear") int releaseYear, @Param("author") String author);

}
