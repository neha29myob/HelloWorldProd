package HandlersTests;

import Controller.GreetingRepository;
import Handlers.GreetingPageHandler;
import Handlers.RemoveNameHandler;
import com.sun.net.httpserver.HttpExchange;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.mockito.Mockito.*;

public class GreetingHandlerTest {

    private GreetingPageHandler greetingPageHandler;
    private HttpExchange httpExchange;
    private GreetingRepository greetingRepository;
    private OutputStream outputStream;

    @Before
    public void setUp(){
        greetingRepository = mock(GreetingRepository.class);
        httpExchange = mock(HttpExchange.class);
        outputStream = mock(OutputStream.class);
        greetingPageHandler = new GreetingPageHandler(greetingRepository);
    }

    @Test
    public void greetingHandlerShouldCallGetGreetingService() throws IOException {

        when(greetingRepository.getGreetingMessage()).thenReturn("Hello Neha.");
        when(httpExchange.getResponseBody()).thenReturn(outputStream);

        greetingPageHandler.handle(httpExchange);

        verify(greetingRepository).getGreetingMessage();
    }
}
