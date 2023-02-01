package com.api.bootrestbook.Controller;

import com.api.bootrestbook.entities.Book;
import com.api.bootrestbook.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class bookController {
    @Autowired
    private BookServices bookServices;
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks()
    {
       List<Book> list = this.bookServices.getAllbooks();
       if(list.size() <=0)
       {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       return ResponseEntity.of(Optional.of(list));
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id)
    {
        Book book = this.bookServices.getBookbyID(id);
        if(book == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book)
    {
        Book b = null;
        try
        {
            b = this.bookServices.addBook(book);
            System.out.println(book);
            return ResponseEntity.of(Optional.of(b));
        }
        catch (Exception e)
        {
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
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
