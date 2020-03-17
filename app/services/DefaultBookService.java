package services;

import models.Book;
import repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

public class DefaultBookService implements BookService  {
    private BookRepository bookRepository;

    @Inject
    public DefaultBookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book getDummy(){
        final Book book = new Book();
        book.setId(1L);
        book.setDescription("Dies ist ein Testbuch");
        book.setIsbn10("1231231231");
        book.setIsbn13("123-1231231231");
        book.setPages(2);
        book.setPublisher("Test");
        book.setTitle("Das Testbuch");
        return book;
    }

    public CompletionStage<Stream<Book>> get() {
        return bookRepository.list();
    }

    public CompletionStage<Book> get(final Long id) {
        return bookRepository.find(id);
    }

    public CompletionStage<Boolean> delete(final Long id){
        return bookRepository.remove(id);
    }

    public CompletionStage<Book> update(final Book book){
        return bookRepository.update(book);
    }

    public CompletionStage<Book> add(final Book book){
        return bookRepository.add(book);
    }



}
