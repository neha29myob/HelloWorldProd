package HandlersTests;

import Controller.GreetingRepository;
import Handlers.AddNameHandler;
import Handlers.UpdateNameHandler;
import com.sun.net.httpserver.HttpExchange;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.mockito.Mockito.*;

public class UpdateNameHandlerTest {
    private UpdateNameHandler updateNameHandler;
    private HttpExchange httpExchange;
    private GreetingRepository greetingRepository;
    private OutputStream outputStream;

    @Before
    public void setUp(){
        greetingRepository = mock(GreetingRepository.class);
        httpExchange = mock(HttpExchange.class);
        outputStream = mock(OutputStream.class);
        updateNameHandler = new UpdateNameHandler(greetingRepository);
    }

    @Test
    public void updateHandlerShouldCallUpdateNameService() throws IOException {
        String mockedInput = "Mary,Bob";

        InputStream inputStream = new ByteArrayInputStream(mockedInput.getBytes());

        when(httpExchange.getRequestBody()).thenReturn(inputStream);
        when(greetingRepository.updateName("Mary", "Bob")).thenReturn("Mary name updated to Bob.");
        when(httpExchange.getResponseBody()).thenReturn(outputStream);

        updateNameHandler.handle(httpExchange);

        verify(greetingRepository).updateName("Mary","Bob");
    }
}
