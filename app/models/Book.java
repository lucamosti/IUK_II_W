package models;

public class Book {
    private int id;
    private String title;
    private String isbn13;
    private String isbn10;
    private String description;
    private String publisher;
    private int pages;


    public Book(int id, String title, String isbn13, String isbn10, String description, String publisher, int pages) {
        this.id = id;
        this.title = title;
        this.isbn13 = isbn13;
        this.isbn10 = isbn10;
        this.description = description;
        this.publisher = publisher;
        this.pages = pages;
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

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}