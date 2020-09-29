package pl.samson.Library.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.samson.Library.manager.LibraryManager;
import pl.samson.Library.repo.entity.Book;

import java.util.Optional;

@RestController
@RequestMapping("/api/library")
public class LibraryApi {

    private LibraryManager libraryManager;

    @Autowired
    public LibraryApi(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @GetMapping("/all")
    public Iterable<Book> getAllBooks() {
        return libraryManager.findAll();
    }

    @GetMapping
    public Optional<Book> getBookById(@RequestParam Integer id) {
        return libraryManager.findById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return libraryManager.save(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return libraryManager.save(book);
    }

    @DeleteMapping
    public void deleteBook(@RequestParam Integer id) {
        libraryManager.deleteById(id);
    }
}
