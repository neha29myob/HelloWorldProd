import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositoryImpl {
    public static List<String> names;

    static {
        names = new ArrayList<>();
    }

    public static String getAll(){
        String person = names.stream().collect(Collectors.joining(", "));
        return person;
    }

    public static void addName(String name){
        names.add(name);
    }

    public static void deleteName(String name) {
        names.remove(name);
    }
    public static void updateName(String name) {
        names.remove(name);
    }
}
