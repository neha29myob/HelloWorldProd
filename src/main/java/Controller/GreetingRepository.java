package Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class GreetingRepository {

    private static final String DEFAULT_NAME = "Neha";
    private static List<String> names;

    public GreetingRepository() {
        names = new ArrayList<>();
        names.add(DEFAULT_NAME);
    }

    public String getGreetingMessage(){
        return "Hello " + getAll() + " - the time on the server is " + getCurrentDate();
    }

    public String getAll(){
        return names.stream().collect(Collectors.joining(", "));
    }

    public String addName(String name){

        if (!isInList(name)){
            names.add(name);
            return name + " added.";
        }
        return name + " already exists.";
    }

    public String deleteName(String name) {
        if (isInList(name) && !name.equalsIgnoreCase(DEFAULT_NAME)){
            names.remove(name);
            return name + " removed.";
        }
        return name + " not found/can't be removed.";
    }

    public String updateName(String oldName, String updatedName) {
        if (isInList(oldName)){
            names.set(names.indexOf(oldName), updatedName);
            return oldName + " name updated to " + updatedName;
        }
       return oldName + " not found.";
    }

    private String getCurrentDate() {
        Date today = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy hh:mm a");
        return dateFormat.format(today);
    }

    public boolean isInList(String name){
        return names.stream().anyMatch(itemName -> itemName.trim().equalsIgnoreCase(name));
        }
}
