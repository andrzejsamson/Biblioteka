public class Book {
    private int id;
    private String title;
    private String author;
    private String publishedBy;
    private String publishingYear;
    private String category;
    private String status;
    private int ownerNumber;
    private String date;

    public Book(int id, String title, String author, String publishedBy, String publishingYear, String category, String status, int ownerNumber, String date) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishedBy = publishedBy;
        this.publishingYear = publishingYear;
        this.category = category;
        this.status = status;
        this.ownerNumber = ownerNumber;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(String publishedBy) {
        this.publishedBy = publishedBy;
    }

    public String getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(String publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOwnerNumber() {
        return ownerNumber;
    }

    public void setOwnerNumber(int ownerNumber) {
        this.ownerNumber = ownerNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
