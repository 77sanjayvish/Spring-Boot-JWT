package com.crud.controller;

import com.crud.entity.Book;
import com.crud.entity.User;
import com.crud.enums.Role;
import com.crud.repository.BookRepository;
import com.crud.repository.UserRepository;
import com.crud.service.BookService;
import com.crud.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/create")
    public Book createBook(@RequestBody Book book,@RequestHeader("Authorization") String token){
        String username = jwtService.extractUserName(token.substring(7));
        User user = (User) userRepository.findByEmail(username);
        if(user != null){
            book.setUser(user);
           return bookRepository.save(book);
        }
        return null;
    }
    @GetMapping("/getAll")
    public Optional<List<Book>> getAll(@RequestHeader("Authorization") String token) throws Exception {
        String username = jwtService.extractUserName(token.substring(7));
        User user = (User) userRepository.findByEmail(username);

        if(user != null && (user.getRole().equals(Role.ADMIN) || user.getRole().equals(Role.USER))){
            return Optional.of(bookRepository.findAll());
        }
        else {
            throw new Exception("UNAUTHORIZED");
        }
    }
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
        return "Delete Book Successfully.......";
    }
    @GetMapping("/{id}")
    public Optional<Book> getSingleBook(@PathVariable int id){
       return bookService.getBook(id);
    }


    @PutMapping("/update")
    public Optional<Book> updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

}
