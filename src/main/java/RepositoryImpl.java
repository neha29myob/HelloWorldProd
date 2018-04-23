import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositoryImpl {
    public static List<String> names;

    static {
        names = new ArrayList<>();
    }

    public static String getAll(){
        //names.add("Neha");

        String person = names.stream().collect(Collectors.joining(", "));
//        if(person == null){
//            return "Neha";
//        }
        return person;
    }

    public static void addName(String name){

        names.add(name);
        //String person = names.stream().collect(Collectors.joining(", "));
    }

    public static void deleteName(String name) {
        names.remove(name);

    }
}
