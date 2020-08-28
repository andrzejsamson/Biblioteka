import java.util.ArrayList;

public class User {
    private int libraryCardNumber;
    private String firstName;
    private String secondName;
    private String address;
    private String phoneNumber;
    private String email;

    public User(int libraryCardNumber, String firstName, String secondName, String address, String phoneNumber, String email) {
        this.libraryCardNumber = libraryCardNumber;
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public void setLibraryCardNumber(int libraryCardNumber) {
        this.libraryCardNumber = libraryCardNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Book> search(Library library) {
        if(library.getUsers().contains(this)) {
            return library.getBooks();
        } else {
            System.out.println("You are not a user in this library");
        }
        return null;
    }

    public boolean reservation(Library library, Book book) {
        if(library.getUsers().contains(this)) {
            for(Book books : library.getBooks()) {
                if(books.equals(book) && books.getStatus().equals("free")) {
                    books.setStatus("reserved");
                    books.setOwnerNumber(this.getLibraryCardNumber());
                    return true;
                }
            }
        } else {
            System.out.println("You are not a user in this library");
        }
        return false;
    }

    public boolean cancelReservation(Library library, Book book) {
        if(library.getUsers().contains(this)) {
            for(Book books : library.getBooks()) {
                if(book.equals(book) && books.getStatus().equals("reserved") && books.getOwnerNumber() == this.libraryCardNumber) {
                    books.setStatus("free");
                    books.setOwnerNumber(0);
                    return true;
                }
            }
        } else {
            System.out.println("You are not a user in this library");
        }
        return false;
    }
}
