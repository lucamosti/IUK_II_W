package services;

import com.google.inject.ImplementedBy;
import models.Book;

import java.util.List;
import java.util.concurrent.CompletionStage;

@ImplementedBy(DefaultNYTimesService.class)
public interface NYTimesService {

    /**
     * Return's current bestseller list.
     * @return bestseller list
     */
    CompletionStage<List<Book>> bestseller();
}
