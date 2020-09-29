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

    public Book save(Book book) {
        return bookRepo.save(book);
    }

    public void deleteById(int id) {
        bookRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Book(1, "Harry Potter", "J.K. Rowling", Status.FREE));
        save(new Book(2, "Outlander", "D. Gabaldon", Status.FREE));
    }
}
