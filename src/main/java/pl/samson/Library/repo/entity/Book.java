package pl.samson.Library.repo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String title;
    private String author;
    private Status status;

    public Book() {
    }

    public Book(int id, String title, String author, Status status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
