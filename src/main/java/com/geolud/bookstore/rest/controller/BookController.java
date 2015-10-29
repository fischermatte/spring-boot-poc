package com.geolud.bookstore.rest.controller;

import com.geolud.bookstore.books.service.BookService;
import com.geolud.bookstore.books.service.data.BookData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/book", produces = "application/json")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/isbn/{isbn}")
    public BookData getBook(@PathVariable String isbn) {
        return bookService.findByIsbn(isbn);
    }
}
