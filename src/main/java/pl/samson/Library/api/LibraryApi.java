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

    @GetMapping("/searchId")
    public Optional<Book> getBookById(@RequestParam Integer id) {
        return libraryManager.findById(id);
    }

    @GetMapping("/searchTitle")
    public Iterable<Book> getBookByTitle(@RequestParam String title) {
        return libraryManager.findByTitle(title);
    }

    @GetMapping("/searchAuthor")
    public Iterable<Book> getBookByAuthor(@RequestParam String author) {
        return libraryManager.findByAuthor(author);
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        return libraryManager.save(book);
    }

    @PutMapping("/changeBook")
    public Book updateBook(@RequestBody Book book) {
        return libraryManager.save(book);
    }

    @PatchMapping("/reservation")
    public String reservation(@RequestParam Integer id) {
        return libraryManager.reservation(id);
    }

    @PatchMapping("/loan")
    public String loan(@RequestParam Integer id) {
        return libraryManager.loan(id);
    }

    @PatchMapping("/returnBook")
    public String returnBook(@RequestParam Integer id) {
        return libraryManager.returnBook(id);
    }

    @DeleteMapping("/deleteBook")
    public String deleteBook(@RequestParam Integer id) {
        return libraryManager.deleteById(id);
    }
}
