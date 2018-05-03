package Handlers;

import Controller.GreetingRepository;
import IO.InputReader;
import IO.ResponseWriter;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class RemoveNameHandler implements HttpHandler {
    private GreetingRepository greetingRepository;

    public RemoveNameHandler(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String name = InputReader.readInput(httpExchange);
        String greetingResponse = greetingRepository.deleteName(name);
        ResponseWriter.handleResponse(httpExchange, greetingResponse);
    }
}
