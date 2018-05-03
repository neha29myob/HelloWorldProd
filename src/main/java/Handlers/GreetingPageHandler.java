package Handlers;

import Controller.GreetingRepository;
import IO.ResponseWriter;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class GreetingPageHandler implements HttpHandler {

    private GreetingRepository repository;

    public GreetingPageHandler(GreetingRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String greetingResponse = repository.getGreetingMessage();
        ResponseWriter.handleResponse(httpExchange, greetingResponse);
    }

}
