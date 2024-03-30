// Book.java

package book.model;

import java.util.List;

public class Book {
    private String title;
    private String author;
    private int year;

    // Constructor, getters, setters

    public Book(String title, String author, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.year = yearOfPublication;
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

    public int getYear() {
        return year;
    }

    public void setYear(int yearOfPublication) {
        this.year = yearOfPublication;
    }

}
