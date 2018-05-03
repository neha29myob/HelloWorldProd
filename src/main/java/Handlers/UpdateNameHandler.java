package Handlers;

import Controller.GreetingRepository;
import IO.InputReader;
import IO.ResponseWriter;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class UpdateNameHandler implements HttpHandler {

    private GreetingRepository greetingRepository;

    public UpdateNameHandler(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String names = InputReader.readInput(httpExchange);

        String oldName = names.split(",")[0];
        String updatedName = names.split(",")[1];
        String greetingResponse = greetingRepository.updateName(oldName, updatedName);

        ResponseWriter.handleResponse(httpExchange, greetingResponse);
    }

}
