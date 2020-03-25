package controllers;

import play.libs.Json;

import play.mvc.Controller;
import play.mvc.Result;

import services.NYTimesService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's bestseller page.
 */
public class BestsellerController extends Controller {

    private final NYTimesService nyTimesService;

    @Inject
    public BestsellerController(NYTimesService nyTimesService) {
        this.nyTimesService = nyTimesService;
    }

    public CompletionStage<Result> bestseller() {
        return nyTimesService.bestseller().thenApplyAsync(bestseller -> ok(Json.toJson(bestseller)));
    }
}
