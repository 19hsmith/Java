package com.harry.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harry.bookclub.models.Book;
import com.harry.bookclub.repositories.BookRepository;
@Service
public class BookService {

    @Autowired BookRepository bookRepository;

    public void addBook(Book book){
        bookRepository.save(book);

    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public Book getOne(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }

    public void destroyBook(Long id){
        bookRepository.deleteById(id);
    }
    
}