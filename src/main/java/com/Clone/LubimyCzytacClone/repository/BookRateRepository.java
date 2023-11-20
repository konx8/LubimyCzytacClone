package com.Clone.LubimyCzytacClone.repository;

import com.Clone.LubimyCzytacClone.entity.BookRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRateRepository extends JpaRepository<BookRate, Long> {

}
