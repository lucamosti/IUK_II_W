package services;

import models.Book;

import java.util.ArrayList;
import java.util.List;

public class DefaultBookService implements BookService  {
    private List<Book> BookList = new ArrayList<>();

    @Override
    public List<Book> get() {
        return BookList;
    }

    @Override
    public Book get(int id) {
        for(Book book : BookList){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        return BookList.removeIf(book -> book.getId()==id);
    }

    @Override
    public Book update(Book updatedBook) {
        delete(updatedBook.getId());
        BookList.add(updatedBook);
        return BookList.get(BookList.size()-1);
    }

    @Override
    public Book add(Book book) {
        BookList.add(book);
        return BookList.get(BookList.size()-1);
    }

    public Book search(String q){
        for(Book book : BookList){
            if(book.getTitle().equalsIgnoreCase(q)) {
                return book;
            }
        }
        return null;
    }
}
