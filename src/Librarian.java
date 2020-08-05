import java.util.ArrayList;

public class Librarian extends User {
    private int employeeId;

    public Librarian(String firstName, String lastName, String address, String phoneNumber, String email, int employeeId) {
        super(firstName, lastName, address, phoneNumber, email);
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public ArrayList<Book> search(ArrayList<Book> bookList) {
        return bookList;
    }

    @Override
    public void cancelReservation(Book book) {
        if(book.getStatus().equals("reserved")) {
            book.setStatus("free");
            book.setOwner(null);
            System.out.println("This reservation was cancelled successfully");
        } else {
            System.out.println("Operation failed");
            System.out.println("You can not cancel this");
        }
    }

    public void addBook(Library library, int id, String title, String author, String publishedBy, String category) {
        library.getLibrary().add(new Book(id, title, author, publishedBy, category, "free", null));
        System.out.println("New book added to library");
    }

    public void returnBook(Book book) {
        if(book.getStatus().equals("loaned")) {
            book.setStatus("free");
            book.setOwner(null);
            System.out.println("Book has been successfully returned");
        } else {
            System.out.println("Operation failed");
            System.out.println("You can not return this book");
        }
    }
}
