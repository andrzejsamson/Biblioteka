public class NormalUser extends User {
    private int libraryCardNumber;

    public NormalUser(String firstName, String lastName, String address, String phoneNumber, String email, int libraryCardNumber) {
        super(firstName, lastName, address, phoneNumber, email);
        this.libraryCardNumber = libraryCardNumber;
    }

    public int getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public void setLibraryCardNumber(int libraryCardNumber) {
        this.libraryCardNumber = libraryCardNumber;
    }

    public void reservation(Book book) {
        if(book.getStatus().equals("free")) {
            book.setStatus("reserved");
            book.setOwner(this);
            System.out.println(book.getTitle() + " was reserved successfully!");
        } else {
            System.out.println("The status of the book is: " + book.getStatus());
            System.out.println("You can not reserve " + book.getTitle());
        }
    }
}
