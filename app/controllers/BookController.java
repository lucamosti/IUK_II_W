package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Book;
import play.libs.Json;
import play.mvc.*;
import services.DefaultBookService;

public class BookController extends Controller {

    DefaultBookService bookService;

    public BookController() {
        bookService = new DefaultBookService();
    }


    public Result books(String q) {
        if(q != null){
            return ok(Json.toJson(bookService.search(q)));
        }
        else {
            return ok(Json.toJson(bookService.get()));
        }
    }

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
