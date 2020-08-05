import java.util.ArrayList;

public class User {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;

    public User(String firstName, String lastName, String address, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public ArrayList<Book> search(ArrayList<Book> bookList) {
        ArrayList<Book> searchingList = new ArrayList<>();
        for(Book book : bookList) {
            if(book.getStatus().equals("free")) {
                searchingList.add(book);
            }
        }
        return searchingList;
    }

    public void cancelReservation(Book book) {
        if((book.getStatus().equals("reserved")) && (book.getOwner().equals(this))) {
            book.setStatus("free");
            book.setOwner(null);
            System.out.println("Your reservation was cancelled successfully");
        } else {
            System.out.println("Operation failed");
            System.out.println("You can not cancel this reservation");
        }
    }
}
