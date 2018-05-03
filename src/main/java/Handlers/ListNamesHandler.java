package Handlers;

import Controller.GreetingRepository;
import IO.ResponseWriter;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class ListNamesHandler implements HttpHandler {
    private GreetingRepository greetingRepository;

    public ListNamesHandler(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String greetingResponse = greetingRepository.getAll();
        ResponseWriter.handleResponse(httpExchange, greetingResponse);
    }
}
