package com.cxb.springboot.web;


import com.cxb.springboot.entity.Book;
import com.cxb.springboot.feign.IBookClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FeignController {

    private IBookClient bookClient;

    @Autowired
    public FeignController(final IBookClient bookClient) {
        this.bookClient = bookClient;
    }

    @GetMapping(path = "/getBookById", produces = "application/json; charset=utf-8")
    public Book getBookById(@RequestParam("bookId") Long bookId) {
        Book book = bookClient.getBookById(bookId);
        return book;
    }
}

