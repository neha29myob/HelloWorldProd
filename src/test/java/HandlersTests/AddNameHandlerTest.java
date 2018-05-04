package HandlersTests;

import Controller.GreetingRepository;
import Handlers.AddNameHandler;
import org.junit.Before;
import org.junit.Test;

import com.sun.net.httpserver.HttpExchange;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.mockito.Mockito.*;

public class AddNameHandlerTest {
    private AddNameHandler addNameHandler;
    private HttpExchange httpExchange;
    private GreetingRepository greetingRepository;
    //private O
    private OutputStream outputStream;

    @Before
    public void setUp(){
        greetingRepository = mock(GreetingRepository.class);
        httpExchange = mock(HttpExchange.class);
        outputStream = mock(OutputStream.class);
        addNameHandler = new AddNameHandler(greetingRepository);
    }

    @Test
    public void addHandlerShouldCallAddNameService() throws IOException {
        String mockedInput = "Mary";
        InputStream inputStream = new ByteArrayInputStream(mockedInput.getBytes());

        when(httpExchange.getRequestBody()).thenReturn(inputStream);
        when(greetingRepository.addName(mockedInput)).thenReturn("Mary added.");
        when(httpExchange.getResponseBody()).thenReturn(outputStream);

        addNameHandler.handle(httpExchange);

        verify(greetingRepository).addName("Mary");
        //verify(outputStream).("Mary");
    }
}
