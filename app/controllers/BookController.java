package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Book;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.*;
import services.DefaultBookService;
import com.fasterxml.jackson.databind.JsonNode;
import models.Book;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import services.BookService;
import services.DefaultBookService;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

public class BookController extends Controller {

    private final BookService bookService;

    @Inject
    public BookController(BookService bookService, HttpExecutionContext ec) {
        this.bookService = bookService;
    }

    public CompletionStage<Result> books(String q) {
        return bookService.get().thenApplyAsync(bookStream ->
                ok(Json.toJson(bookStream.collect(Collectors.toList())))
        );
    }

    public CompletionStage<Result> get(Long id){
        return bookService.get(id).thenApplyAsync(book -> ok(Json.toJson(book)));
    }

    public CompletionStage<Result> update(Http.Request request){
        final JsonNode jsonBook = request.body().asJson();
        final Book bookToUpdate = Json.fromJson(jsonBook, Book.class);
        final Long id = bookToUpdate.getId();
        bookToUpdate.setId(id);
        return bookService.update(bookToUpdate).thenApplyAsync(book -> ok(Json.toJson(book)));
    }

    public CompletionStage<Result> details(Long id){
        return bookService.get(id).thenApplyAsync(book -> ok(Json.toJson(book)));
    }

    public CompletionStage<Result> delete(Long id){
        return bookService.delete(id).thenApplyAsync(removed -> removed ? ok() : internalServerError());
    }

    public CompletionStage<Result> add(Http.Request request){
        final JsonNode jsonBook = request.body().asJson();
        final Book bookToAdd = Json.fromJson(jsonBook, Book.class);
        return bookService.add(bookToAdd).thenApplyAsync(book -> ok(Json.toJson(book)));
    }

}

/*
    public Result get(int id) {
        return ok(Json.toJson(bookService.get(id)));
    }

    public Result add(Http.Request request) {
        JsonNode jsonBook = request.body().asJson();
        Book book = Json.fromJson(jsonBook, Book.class);
        return ok(Json.toJson(bookService.add(book)));
    }

    public Result update(Http.Request request) {
        JsonNode jsonBook = request.body().asJson();
        Book book = Json.fromJson(jsonBook, Book.class);
        return ok(Json.toJson(bookService.update(book)));
    }

    public Result delete(int id) {
        return ok(Json.toJson(bookService.delete(id)));
    }
}
*/