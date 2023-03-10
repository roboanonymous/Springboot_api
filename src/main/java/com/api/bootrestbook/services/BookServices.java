package com.api.bootrestbook.services;

import com.api.bootrestbook.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookServices {

    private static List<Book> list = new ArrayList<>();

    static {
//
//        list.add(new Book(12, "Java Complete Referane" , "Samyak Jain"));
//        list.add(new Book(13, "Python Complete Referane" , "Sambhav Jain"));
//        list.add(new Book(14, "C++ Complete Referane" , "Dhruv Gupta"));
//        list.add(new Book(15, "JavaScript Complete Referane" , "Deepak Gupta"));
    }

    //get all books
    public List<Book> getAllbooks()
    {
        return list;
    }

    public Book getBookbyID(int id)
    {
        Book book = null;
        try
        {
            book =  list.stream().filter(e->e.getId() == id).findFirst().get();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return book;
    }

    public Book addBook(Book b)
    {
        list.add(b);
        return b;
    }

    public void deleteBook( int id)
    {
        list = list.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
    }

    public void updateBook(Book book, int id)
    {
        list.stream().map(b ->{
           if(b.getId()== id)
           {
               b.setTitle(book.getTitle());
               b.setAuthor(book.getAuthor());
           }
           return b;
        }).collect(Collectors.toList());
    }

}
