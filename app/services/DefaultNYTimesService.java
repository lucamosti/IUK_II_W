package services;

import com.fasterxml.jackson.databind.JsonNode;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import models.Book;
import models.nytimes.NYTimesBestseller;
import models.nytimes.NYTimesBook;
import models.nytimes.NYTimesReviewList;
import play.libs.Json;
import play.libs.ws.*;
import java.util.concurrent.CompletionStage;
import com.typesafe.config.Config;

public class DefaultNYTimesService implements NYTimesService, WSBodyReadables {

    private final WSClient ws;
    private final String apiKey;

    @Inject
    public DefaultNYTimesService(WSClient ws, Config config) {
        this.ws = ws;
        this.apiKey = config.getString("nytimes.api.key");
    }

    @Override
    public CompletionStage<List<Book>> bestseller() {
        final String url = "https://api.nytimes.com/svc/books/v3/lists/overview.json";
        final WSRequest request = ws.url(url).addQueryParameter("api-key", apiKey);
        final CompletionStage<JsonNode> jsonPromise = request.get().thenApply(result -> result.getBody(json()));
        final CompletionStage<NYTimesBestseller> bestsellerPromise = jsonPromise.thenApplyAsync(json -> Json.fromJson(json, NYTimesBestseller.class));
        final CompletionStage<List<Book>> booksPromise = bestsellerPromise.thenApplyAsync(bestseller -> map(bestseller));
        return booksPromise;
    }

    /**
     * Maps New York times bestseller list to book list.
     *
     * @param bestseller list
     * @return mapped list of books
     */
    private List<Book> map(NYTimesBestseller bestseller) {
        final List<Book> books = new ArrayList<>();
        for (NYTimesReviewList list : bestseller.getResults().getLists()) {
            if (list.getList_id() == 704) {
                list.getBooks().forEach(nyTimesBook -> books.add(map(nyTimesBook)));
            }
        }
        return books;
    }

    /**
     * Maps New York times book representation to a Book.
     *
     * @param nyTimesBook
     * @return mapped book
     */
    private Book map(NYTimesBook nyTimesBook) {
        final Book book = new Book();
        book.setDescription(nyTimesBook.getDescription());
        book.setIsbn10(nyTimesBook.getPrimary_isbn10());
        book.setIsbn13(nyTimesBook.getPrimary_isbn13());
        book.setTitle(nyTimesBook.getTitle());
        book.setPublisher(nyTimesBook.getPublisher());
        return book;

    }
}