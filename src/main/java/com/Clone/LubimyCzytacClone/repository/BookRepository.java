package com.Clone.LubimyCzytacClone.repository;

import com.Clone.LubimyCzytacClone.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("SELECT b FROM Book b WHERE b.title = :title AND b.author = :author")
    Book getBookByTitleAndAuthor(@Param("title") String title, @Param("author") String author);

}
