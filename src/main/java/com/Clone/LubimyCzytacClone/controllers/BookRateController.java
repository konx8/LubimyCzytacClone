package com.Clone.LubimyCzytacClone.controllers;

import com.Clone.LubimyCzytacClone.entity.BookRate;
import com.Clone.LubimyCzytacClone.services.BookRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class BookRateController {

    private BookRateService bookRateService;

    @Autowired
    public BookRateController(BookRateService bookRateService) {
        this.bookRateService = bookRateService;
    }


    @PostMapping("/bookRate")
    public BookRate setBookRate(@RequestBody BookRate bookRate){

        return bookRateService.setBookRate(bookRate);

    }

    @GetMapping("/booksRates")
    public List<BookRate> getBooksRates(){

        return bookRateService.getBooksRates();

    }

}
