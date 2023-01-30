package com.api.bootrestbook.Controller;

import com.api.bootrestbook.entities.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class bookController {
    @GetMapping("/books")
    public Book getBooks()
    {
        Book book = new Book();
        book.setId(1234);
        book.setTitle("Zero to one");
        book.setAuthor("Peter theil");
        return book;
    }
}
