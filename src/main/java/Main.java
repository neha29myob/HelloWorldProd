import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Main {

    private static List<String> names;

    public static void main(String[] args) throws Exception {

        names = new ArrayList<>();
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/hello", new GreetingPageHandler());
        server.createContext("/list", new ListNamesHandler());
        server.createContext("/add", new AddNameHandler());
        server.createContext("/delete", new RemoveNameHandler());

        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
    }

        static class NotImplementedHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            exchange.sendResponseHeaders(501, -1);
            exchange.close();
        }
    }


}
