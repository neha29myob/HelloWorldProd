import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GreetingPageHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy hh:mm a");
        Date today = new Date();
        String requestMethod = httpExchange.getRequestMethod();
        if (requestMethod.equalsIgnoreCase("GET")) {
            httpExchange.getResponseHeaders().set("Content-Type", "text/plain");
            httpExchange.sendResponseHeaders(200, 0);

            String names = RepositoryImpl.getAll();

            String greetingResponse = "Hello Neha, " + names + " - the time on the server is " + dateFormat.format(today).replace("AM", "am").replace("PM", "pm");

            OutputStream responseBody = httpExchange.getResponseBody();
            responseBody.write(greetingResponse.getBytes());
            responseBody.close();
        }
    }
}
