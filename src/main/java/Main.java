import Handlers.*;
import Controller.GreetingRepository;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        GreetingRepository greetingRepository = new GreetingRepository();

        server.createContext("/", new GreetingPageHandler(greetingRepository));
        server.createContext("/list", new ListNamesHandler(greetingRepository));
        server.createContext("/add", new AddNameHandler(greetingRepository));
        server.createContext("/delete", new RemoveNameHandler(greetingRepository));
        server.createContext("/update", new UpdateNameHandler(greetingRepository));

        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
        System.out.println("Server started at port 8000");
    }

}
