package com.api.bootrestbook.Controller;

import com.api.bootrestbook.entities.Book;
import com.api.bootrestbook.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class bookController {
    @Autowired
    private BookServices bookServices;
    @GetMapping("/books")
    public List<Book> getBooks()
    {
        return this.bookServices.getAllbooks();
    }
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id)
    {
        return this.bookServices.getBookbyID(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book)
    {
        Book b = this.bookServices.addBook(book);
        System.out.println(book);
        return b;
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int id)
    {
        this.bookServices.deleteBook(id);
    }

    @PutMapping("/books/{id}")
    public Book updateBooks(@RequestBody Book book , @PathVariable("id") int id)
    {
        this.bookServices.updateBook(book, id);
        return book;
    }

}
