import java.util.ArrayList;

public class Library {
    private String libraryName;
    private ArrayList<Book> library;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.library = new ArrayList<>();
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public ArrayList<Book> getLibrary() {
        return library;
    }

    public void setLibrary(ArrayList<Book> library) {
        this.library = library;
    }
}
