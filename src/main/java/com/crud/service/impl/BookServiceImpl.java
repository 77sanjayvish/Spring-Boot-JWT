package com.crud.service.impl;

import com.crud.entity.Book;
import com.crud.repository.BookRepository;
import com.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<List<Book>> getAllBooks() {
        return Optional.of(bookRepository.findAll());
    }

    @Override
    public Optional<Book> updateBook(Book book) {

        Book b = new Book();
        b.setBookId(book.getBookId());
        b.setBookName(book.getBookName());
        b.setTitle(book.getTitle());
        b.setPrice(book.getPrice());
        b.setAuthor(book.getAuthor());
        return Optional.of(bookRepository.save(book)); // Save the book if it exists

    }
    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
    @Override
    public Optional<Book> getBook(int id) {
        return bookRepository.findById(id);
    }

}
