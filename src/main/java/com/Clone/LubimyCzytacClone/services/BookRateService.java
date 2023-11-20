package com.Clone.LubimyCzytacClone.services;

import com.Clone.LubimyCzytacClone.entity.BookRate;
import com.Clone.LubimyCzytacClone.repository.BookRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRateService {

    private BookRateRepository bookRateRepository;


    @Autowired
    public BookRateService(BookRateRepository bookRateRepository) {
        this.bookRateRepository = bookRateRepository;
    }

    public BookRate setBookRate(BookRate rate){
        return bookRateRepository.save(rate);

    }


    public List<BookRate> getBooksRates() {

        return bookRateRepository.findAll();

    }
}
