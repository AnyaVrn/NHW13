package org.example;

public class Book  extends Product{
    private String author;

    public Book (int bookId, String bookTitle,String bookAuthor){
        super.id = bookId;

        super.name = bookTitle;

        this.author= bookAuthor;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        return this.author.contains(search);
    }
}