package HandlersTests;

import Controller.GreetingRepository;
import Handlers.RemoveNameHandler;
import com.sun.net.httpserver.HttpExchange;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RemoveNameHandlerTest {

    private RemoveNameHandler removeNameHandler;
    private HttpExchange httpExchange;
    private GreetingRepository greetingRepository;
    private OutputStream outputStream;

    @Before
    public void setUp(){
        greetingRepository = mock(GreetingRepository.class);
        httpExchange = mock(HttpExchange.class);
        outputStream = mock(OutputStream.class);
        removeNameHandler = new RemoveNameHandler(greetingRepository);
    }

    @Test
    public void removeHandlerShouldCallRemoveNameService() throws IOException {
        String mockedInput = "Bob";
        InputStream inputStream = new ByteArrayInputStream(mockedInput.getBytes());

        when(httpExchange.getRequestBody()).thenReturn(inputStream);
        when(greetingRepository.deleteName(mockedInput)).thenReturn("Bob removed.");
        when(httpExchange.getResponseBody()).thenReturn(outputStream);

        removeNameHandler.handle(httpExchange);

        verify(greetingRepository).deleteName("Bob");
    }
}
