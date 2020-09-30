package pl.samson.Library.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.samson.Library.repo.BookRepo;
import pl.samson.Library.repo.entity.Book;
import pl.samson.Library.repo.entity.Status;

import java.util.Optional;

@Service
public class LibraryManager {

    private BookRepo bookRepo;

    @Autowired
    public LibraryManager(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Iterable<Book> findAll() {
        return bookRepo.findAll();
    }

    public Optional<Book> findById(int id) {
        return bookRepo.findById(id);
    }

    public Iterable<Book> findByTitle(String title) {
        return bookRepo.findByTitle(title);
    }

    public Iterable<Book> findByAuthor(String author) {
        return bookRepo.findByAuthor(author);
    }

    public Book save(Book book) {
        return bookRepo.save(book);
    }

    public String reservation(int id) {
        Book book = bookRepo.findById(id).get();
        if(book.getStatus().equals(Status.FREE)) {
            book.setStatus(Status.RESERVED);
            bookRepo.save(book);
            return "Book has been successfully reserved";
        } else {
            return "You can not reserve this book";
        }
    }

    public String loan(int id) {
        Book book = bookRepo.findById(id).get();
        if(book.getStatus().equals(Status.RESERVED)) {
            book.setStatus(Status.LOANED);
            bookRepo.save(book);
            return "Book has been successfully loaned";
        } else {
            return "You can not loan this book";
        }
    }

    public String returnBook(int id) {
        Book book = bookRepo.findById(id).get();
        if(book.getStatus().equals(Status.LOANED)) {
            book.setStatus(Status.FREE);
            bookRepo.save(book);
            return "Book has been successfully returned";
        } else {
            return "You can not return this book";
        }
    }

    public String deleteById(int id) {
        bookRepo.deleteById(id);
        return "Book has been successfully deleted";
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Book(1, "Harry Potter i Kamień Filozoficzny", "J.K. Rowling", Status.FREE));
        save(new Book(2, "Harry Potter i Komnata Tajemnic", "J.K. Rowling", Status.FREE));
        save(new Book(3, "Outlander", "D. Gabaldon", Status.FREE));
    }
}
