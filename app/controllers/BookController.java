package controllers;

import play.mvc.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class BookController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {

        return ok(views.html.index.render());
    }


    public Result books(String q) {

        return ok("Alle Bücher zurückgeben.");
    }

    public Result add() {

        return ok("Buch hinzugefügt.");
    }

    public Result update(long id, Http.Request request) {

        return ok("Buch wurde aktualisiert");
    }

    public Result get(long id) {

        return ok("Buch mit der ID 5 wird zurückgegeben.");
    }

    public Result search(String q) {

        return ok("Buch mit Titel wird zurückgegeben.");
    }

    public Result delete(long id) {

        return ok("Buch wird gelöscht.");
    }
}
