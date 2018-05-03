package IO;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class ResponseWriter {

    public static void handleResponse(HttpExchange httpExchange, String greetingResponse) throws IOException {
        httpExchange.sendResponseHeaders(200, 0);
        OutputStream responseBody = httpExchange.getResponseBody();
        responseBody.write(greetingResponse.getBytes());
        responseBody.close();
    }
}
