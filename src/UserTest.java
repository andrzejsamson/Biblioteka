import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserTest {
    private static Library library;
    private static Book book1;
    private static Book book2;
    private static User user1;
    private static User user2;

    @BeforeClass
    public static void setup() {
        library = new Library("Library 1");
        book1 = new Book(1,"Title","Author","Publisher","Year","Category","free",0,null);
        book2 = new Book(2,"Title2","Author2","Publisher2","Year2","Category2","reserved",2,null);
        user1 = new User(1,"FirstName","SecondName","Address","123456789","email@email.com");
        user2 = new User(2,"FirstName2","SecondName2","Address2","1234567892","email@email.com2");
        library.addBooks(book1);
        library.addBooks(book2);
        library.addUsers(user1);
    }

    @Test
    public void searchSuccess() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        assertEquals(books,user1.search(library));
    }

    @Test
    public void searchFail() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        assertNull(user2.search(library));
    }

    @Test
    public void reservationSuccess() {
        assertTrue(user1.reservation(library,book1));
        assertEquals(user1.getLibraryCardNumber(),book1.getOwnerNumber());
        assertEquals("reserved",book1.getStatus());
    }

    @Test
    public void reservationFail1() {
        assertFalse(user2.reservation(library, book1));
    }

    @Test
    public void reservationFail2() {
        assertFalse(user1.reservation(library, book2));
    }

    @Test
    public void cancelReservationSuccess() {
        user1.reservation(library,book1);
        assertTrue(user1.cancelReservation(library,book1));
        assertEquals(0,book1.getOwnerNumber());
        assertEquals("free",book1.getStatus());
    }

    @Test
    public void cancelReservationFail1() {
        assertFalse(user2.cancelReservation(library, book2));
    }

    @Test
    public void cancelReservationFail2() {
        assertFalse(user1.cancelReservation(library, book2));
    }
}