package com.harry.bookclub.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="A title is required!")
    @Size(min=4, max=128, message="title must be between 4 and 128 characters")
    private String title;

    @NotEmpty(message="A author is required!")
    @Size(min=4, max=128, message="author must be between 4 and 128 characters")
    private String author;

    @NotEmpty(message="A thought is required!")
    @Size(min=4, max=128, message="thoughts must be between 4 and 128 characters")
    private String myThoughts;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;



    public Book() {
    }


    public Book(Long id, String title, String author, String myThoughts, User user) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.myThoughts = myThoughts;
        this.user = user;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMyThoughts() {
        return this.myThoughts;
    }

    public void setMyThoughts(String myThoughts) {
        this.myThoughts = myThoughts;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
