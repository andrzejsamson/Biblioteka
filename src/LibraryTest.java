import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {
    private static Library library;
    private static Book book1;
    private static Book book2;
    private static User user1;
    private static User user2;
    private static Librarian librarian1;
    private static Librarian librarian2;

    @BeforeClass
    public static void setup() {
        library = new Library("Library 1");
        book1 = new Book(1,"Title","Author","Publisher","Year","Category","free",0,null);
        book2 = new Book(2,"Title2","Author2","Publisher2","Year2","Category2","free",0,null);
        user1 = new User(1,"FirstName","SecondName","Address","123456789","email@email.com");
        user2 = new User(2,"FirstName2","SecondName2","Address2","1234567892","email@email.com2");
        librarian1 = new Librarian(3,"FirstName3","SecondName3","Address3","12345678923","email@email.com3",100);
        librarian2 = new Librarian(4,"FirstName4","SecondName4","Address4","12345678924","email@email.com4",101);
    }

    @Test
    public void addBooksSuccess() {
        library.addBooks(book1);
        assertTrue("True condition, book is added",library.getBooks().contains(book1));
    }

    @Test
    public void addBookFail() {
        library.addBooks(book1);
        assertFalse("False condition, book is not added",library.getBooks().contains(book2));
    }

    @Test
    public void addUsersSuccess() {
        library.addUsers(user1);
        assertTrue("True condition, user is added",library.getUsers().contains(user1));
    }

    @Test
    public void addUsersFail() {
        library.addUsers(user1);
        assertFalse("False condition, user is not added",library.getUsers().contains(user2));
    }

    @Test
    public void addLibrariansSuccess() {
        library.addLibrarians(librarian1);
        assertTrue("True condition, librarian is added",library.getLibrarians().contains(librarian1));
    }

    @Test
    public void addLibrariansFail() {
        library.addLibrarians(librarian1);
        assertFalse("False condition, librarian is not added",library.getLibrarians().contains(librarian2));
    }
}