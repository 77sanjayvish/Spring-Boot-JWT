package com.crud.service;

import com.crud.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    //Add Book
    Book createBook(Book book);

    //getAll Book
    Optional<List<Book>> getAllBooks();
    // update Book
    Optional<Book> updateBook(Book book);

    //delete Book
    void deleteBook(int id);

    //get Single book
    Optional<Book>  getBook(int id);



}
