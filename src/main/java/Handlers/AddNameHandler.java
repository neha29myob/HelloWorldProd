package Handlers;

import Controller.GreetingRepository;
import IO.InputReader;
import IO.ResponseWriter;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;

public class AddNameHandler implements HttpHandler {
    private GreetingRepository greetingRepository;

    public AddNameHandler(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String name = InputReader.readInput(httpExchange);
        String greetingResponse = greetingRepository.addName(name);
        ResponseWriter responseWriter = new ResponseWriter();
        responseWriter.handleResponse(httpExchange, greetingResponse);
    }
}
