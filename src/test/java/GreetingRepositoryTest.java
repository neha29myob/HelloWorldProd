import Controller.GreetingRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GreetingRepositoryTest {
    private GreetingRepository greetingRepository;

    @Before
    public void setUp(){
         greetingRepository = new GreetingRepository();
    }

    @Test
    public void getGreetingShouldReturnGreetingMessageWithDefaultName(){
        String expected = "Hello Neha - the time on the server is " + getCurrentDate();
        String actual = greetingRepository.getGreetingMessage();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void WhenAddNameReturnNameAddedMessage(){
        String name = "Mary";
        String expected = name + " added.";
        Assert.assertEquals(greetingRepository.addName(name),expected);
    }

    @Test
    public void WhenAddNameReturnUpdatedGreetingMessage(){
        String expected = "Hello Neha, Mary - the time on the server is " + getCurrentDate();
        greetingRepository.addName("Mary");
        Assert.assertEquals(greetingRepository.getGreetingMessage(),expected);
    }

    @Test
    public void WhenAddExistingNameReturnAlreadyExistsMessage(){
        String expected = "Mary already exists.";
        greetingRepository.addName("Mary");
        Assert.assertEquals(greetingRepository.addName("Mary"),expected);
    }

    @Test
    public void WhenDeleteNameReturnAppropriateMessages(){

        String expectedRemovedMessage = "Mary removed.";
        String expectedEternalNameMessage = "Neha not found/can't be removed.";
        String expectedNotFoundMessage = "abcd not found/can't be removed.";

        greetingRepository.addName("Mary");

        Assert.assertEquals(greetingRepository.deleteName("Mary"),expectedRemovedMessage);
        Assert.assertEquals(greetingRepository.deleteName("Neha"),expectedEternalNameMessage);
        Assert.assertEquals(greetingRepository.deleteName("abcd"),expectedNotFoundMessage);
    }

    @Test
    public void WhenUpdateNameReturnAppropriateMessages(){

        String expectedUpdatedMessage = "Mary name updated to Bob";
        String expectedNotFoundMessage = "Terry not found.";

        greetingRepository.addName("Mary");

        Assert.assertEquals(greetingRepository.updateName("Mary","Bob"),expectedUpdatedMessage);
        Assert.assertEquals(greetingRepository.updateName("Terry", ""),expectedNotFoundMessage);
    }

    private String getCurrentDate() {
        Date today = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy hh:mm a");
        return dateFormat.format(today);
    }
}
