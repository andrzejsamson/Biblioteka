import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibrarianTest {
    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;
    private Librarian librarian1;
    private Librarian librarian2;
    private User user1;
    private User user2;

    @Before
    public void setup() {
        library = new Library("Library 1");
        book1 = new Book(1,"Title","Author","Publisher","Year","Category","free",0,null);
        book2 = new Book(2,"Title2","Author2","Publisher2","Year2","Category2","reserved",2,null);
        book3 = new Book(3,"Title3","Author3","Publisher3","Year3","Category3","loaned",1,"30-09-2020");
        librarian1 = new Librarian(3,"FirstName","SecondName","Address","123456789","email@email.com",100);
        librarian2 = new Librarian(4,"FirstName2","SecondName2","Address2","1234567892","email@email.com2",101);
        user1 = new User(1,"FirstName3","SecondName3","Address3","1234567893","email@email.com3");
        user2 = new User(2,"FirstName4","SecondName4","Address4","1234567894","email@email.com4");
        library.addBooks(book1);
        library.addBooks(book2);
        library.addBooks(book3);
        library.addLibrarians(librarian1);
        library.addUsers(user1);
        library.addUsers(user2);
    }

    @Test
    public void searchSuccess() {
        assertEquals(3,librarian1.search(library).size());
    }

    @Test
    public void searchFail() {
        assertNull(librarian2.search(library));
    }

    @Test
    public void cancelReservationSuccess() {
        assertTrue(librarian1.cancelReservation(library, book2, user2));
        assertEquals(0,book2.getOwnerNumber());
        assertEquals("free",book2.getStatus());
    }

    @Test
    public void cancelReservationFail1() {
        assertFalse(librarian2.cancelReservation(library, book2, user2));
    }

    @Test
    public void cancelReservationFail2() {
        assertFalse(librarian1.cancelReservation(library, book1, user2));
    }

    @Test
    public void cancelReservationFail3() {
        assertFalse(librarian1.cancelReservation(library, book2, user1));
    }

    @Test
    public void returnBookSuccess() {
        assertTrue(librarian1.returnBook(library, book3, user1));
        assertEquals(0,book3.getOwnerNumber());
        assertEquals("free",book3.getStatus());
        assertNull(book3.getDate());
    }

    @Test
    public void returnBookFail1() {
        assertFalse(librarian2.returnBook(library, book3, user1));
    }

    @Test
    public void returnBookFail2() {
        assertFalse(librarian1.returnBook(library, book2, user1));
    }

    @Test
    public void returnBookFail3() {
        assertFalse(librarian1.returnBook(library, book3, user2));
    }

    @Test
    public void loanBookSuccess() {
        assertTrue(librarian1.loanBook(library, book2, user2));
        assertEquals(2,book2.getOwnerNumber());
        assertEquals("loaned",book2.getStatus());
        assertEquals("31-10-2020",book2.getDate());
    }

    @Test
    public void loanBookFail1() {
        assertFalse(librarian2.loanBook(library, book2, user2));
    }

    @Test
    public void loanBookFail2() {
        assertFalse(librarian1.loanBook(library, book1, user2));
    }

    @Test
    public void loanBookFail3() {
        assertFalse(librarian1.loanBook(library, book2, user1));
    }

    @Test
    public void addBookSuccess() {
        assertTrue(librarian1.addBook(library,4,"Title4","Author4","Publisher4","Year4","Category4"));
        assertEquals(4,library.getBooks().size());
    }

    @Test
    public void addBookFail() {
        assertFalse(librarian2.addBook(library,4,"Title4","Author4","Publisher4","Year4","Category4"));
        assertNotEquals(4,library.getBooks().size());
    }

    @Test
    public void removeBookSuccess() {
        assertTrue(librarian1.removeBook(library,book1));
        assertEquals(2,library.getBooks().size());
    }

    @Test
    public void removeBookFail1() {
        assertFalse(librarian2.removeBook(library,book3));
    }

    @Test
    public void removeBookFail2() {
        assertFalse(librarian1.removeBook(library,book2));
        assertNotEquals(2,library.getBooks().size());
    }
}