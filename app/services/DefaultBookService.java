package services;

import models.Book;

import java.util.List;

public class DefaultBookService implements BookService  {
    private List<Book> BookList;

    @Override
    public List<Book> get() {
        return BookList;
    }

    @Override
    public Book get(Long id) {
        for(Book book : BookList){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        for(Book book : BookList){
            if(book.getId() == id){
                BookList.remove(book);
                return true;
            }
        }
        return false;
    }

    @Override
    public Book update(Book updatedBook) {
        int id = updatedBook.getId();
        for(Book book : BookList){
            if(book.getId() == id){
                BookList.set(id, updatedBook);
                return updatedBook;
            }
        }
        return null;
    }

    @Override
    public Book add(Book book) {
        return null;
    }
}
