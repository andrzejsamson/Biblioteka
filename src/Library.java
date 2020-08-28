import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private ArrayList<Librarian> librarians;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.librarians = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBooks(Book book) {
        this.books.add(book);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUsers(User user) {
        this.users.add(user);
    }

    public ArrayList<Librarian> getLibrarians() {
        return librarians;
    }

    public void addLibrarians(Librarian librarian) {
        this.librarians.add(librarian);
    }
}
