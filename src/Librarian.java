import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Librarian extends User {
    private int id;

    public Librarian(int libraryCardNumber, String firstName, String secondName, String address, String phoneNumber, String email, int id) {
        super(libraryCardNumber, firstName, secondName, address, phoneNumber, email);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public ArrayList<Book> search(Library library) {
        if(library.getLibrarians().contains(this)) {
            return library.getBooks();
        } else {
            System.out.println("You are not a librarian in this library");
        }
        return null;
    }

    //Overloaded from User(1 argument more)
    public boolean cancelReservation(Library library, Book book, User user) {
        if(library.getLibrarians().contains(this)) {
            for(Book books : library.getBooks()) {
                if (books.equals(book) && books.getStatus().equals("reserved") &&
                        books.getOwnerNumber() == user.getLibraryCardNumber()) {
                    books.setStatus("free");
                    books.setOwnerNumber(0);
                    return true;
                }
            }
        } else {
            System.out.println("You are not a librarian in this library");
        }
        return false;
    }

    public boolean returnBook(Library library, Book book, User user) {
        if(library.getLibrarians().contains(this)) {
            for(Book books : library.getBooks()) {
                if (books.equals(book) && books.getStatus().equals("loaned") &&
                        books.getOwnerNumber() == user.getLibraryCardNumber()) {
                    books.setStatus("free");
                    books.setOwnerNumber(0);
                    books.setDate(null);
                    return true;
                }
            }
        } else {
            System.out.println("You are not a librarian in this library");
        }
        return false;
    }

    public boolean loanBook(Library library, Book book, User user) {
        if(library.getLibrarians().contains(this)) {
            for(Book books : library.getBooks()) {
                if (books.equals(book) && books.getStatus().equals("reserved") &&
                        books.getOwnerNumber() == user.getLibraryCardNumber()) {
                    books.setStatus("loaned");
                    DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDateTime newDate = LocalDateTime.now().plusMonths(2);
                    books.setDate(dft.format(newDate));
                    return true;
                }
            }
        } else {
            System.out.println("You are not a librarian in this library");
        }
        return false;
    }

    public boolean addBook(Library library, int id, String title, String author, String publishedBy, String publishingYear, String category) {
        if(library.getLibrarians().contains(this)) {
            library.addBooks(new Book(id,title,author,publishedBy,publishingYear,category,"free",0,null));
            return true;
        } else {
            System.out.println("You are not a librarian in this library");
        }
        return false;
    }

    public boolean removeBook(Library library, Book book) {
        if(library.getLibrarians().contains(this)) {
            for(Book books : library.getBooks()) {
                if(books.equals(book) && books.getStatus().equals("free")) {
                    library.getBooks().remove(books);
                    return true;
                }
            }
        } else {
            System.out.println("You are not a librarian in this library");
        }
        return false;
    }
}
