package IO;

import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
    public static String readInput(HttpExchange httpExchange) throws IOException {
        InputStreamReader input = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
        BufferedReader reader = new BufferedReader(input);
        return reader.readLine();
    }
}
