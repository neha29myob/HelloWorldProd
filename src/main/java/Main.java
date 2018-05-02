import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/hello", new GreetingPageHandler());
        server.createContext("/list", new ListNamesHandler());
        server.createContext("/add", new AddNameHandler());
        server.createContext("/delete", new RemoveNameHandler());
        server.createContext("/update", new UpdateNameHandler());

        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
        System.out.println("Server started at port 8000");
    }

        static class NotImplementedHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            exchange.sendResponseHeaders(501, -1);
            exchange.close();
        }
    }


}
