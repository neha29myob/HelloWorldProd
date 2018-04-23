import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class AddNameHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        InputStreamReader input = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
        BufferedReader reader = new BufferedReader(input);
        String name = reader.readLine();

        RepositoryImpl.addName(name);

        httpExchange.sendResponseHeaders(200, 0);
        OutputStream responseBody = httpExchange.getResponseBody();
        String greetingResponse = "Added " + name + ".";
        responseBody.write(greetingResponse.getBytes());
        responseBody.close();
    }

}
