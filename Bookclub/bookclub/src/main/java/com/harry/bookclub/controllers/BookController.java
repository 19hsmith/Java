package com.harry.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import com.harry.bookclub.models.Book;
import com.harry.bookclub.services.BookService;


@Controller 

public class BookController {

    @Autowired BookService bookService;

    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("book")Book book){
        return "books/new.jsp";
    }

    @PostMapping("/books")
    public String createBook(@Valid @ModelAttribute("book")Book book, BindingResult result){
        if(result.hasErrors()){
            return "books/new.jsp";
        }else{
            bookService.addBook(book);
            return "redirect:/books"; 
        }
    }

    @GetMapping("/books")
    public String allBooks(Model model){
        model.addAttribute("books", bookService.getAll());
        return"books/index.jsp";
    }

    @GetMapping("/books/{id}")
    public String show(@PathVariable("id")Long id,Model model){
        Book book = bookService.getOne(id);
        model.addAttribute("book", book);
        return "books/show.jsp";
    }

    @GetMapping("/books/edit/{id}")
    public String edit(@PathVariable("id")Long id, Model model,HttpSession session){
        if(session.getAttribute("userId") == null) {
            return "redirect:/books";
        }
        Book book = bookService.getOne(id);
        model.addAttribute("book", book);
        return "books/edit.jsp";
    }

    @PutMapping("/books/{id}")
    public String update(@Valid @ModelAttribute("book")Book book, BindingResult result){
        if(result.hasErrors()){
            return "books/edit.jsp";
        }
        bookService.updateBook(book);
        return "redirect:/books";
    }

    @DeleteMapping("/books/{id}")
    public String destroy(@PathVariable("id")Long id){
        bookService.destroyBook(id);
        return "redirect:/books";
    }
    
}
