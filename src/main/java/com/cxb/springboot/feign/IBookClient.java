package com.cxb.springboot.feign;

import com.cxb.springboot.entity.Book;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers("Content-Type:application/json")
public interface IBookClient {

    @RequestLine("GET /book/getBookById?bookId={bookId}")
    Book getBookById(@Param("bookId") Long bookId);

}