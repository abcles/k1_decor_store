import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class UserInputAskerTest {
    @Test
    public void userIsIntroducingExpectedAnswer() {
        // Giving: Redirect the scanner input
        InputStream originalIn = System.in;

        Integer simulatedUserInput = 10;
        System.setIn(new ByteArrayInputStream(simulatedUserInput.toString().getBytes()));

        UserInputAsker userInputAsker = new UserInputAsker();

        // When
        Integer returnedAnswer = userInputAsker.askUserPositiveInteger("wrongAnswerMessage", 100);

        // Then
        Assert.assertEquals(returnedAnswer, simulatedUserInput);

        // Restore the initial input
        System.setIn(originalIn);
    }

    @Test
    public void userIsIntroducingUnexpectedResult() {
        // Giving: Redirect the scanner input + console output
        InputStream originalIn = System.in;
        String simulatedUserInput = "0" +
                System.getProperty("line.separator") +
                "20";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UserInputAsker userInputAsker = new UserInputAsker();

        // When
        userInputAsker.askUserPositiveInteger("wrongAnswerMessage", 100);

        // Then
        Assert.assertEquals(outContent.toString(), "wrongAnswerMessage" + System.getProperty("line.separator"));

        // Restore the initial input
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void userIsIntroducingAlfanumericalResult() {
        // Giving: Redirect the scanner input + console output
        InputStream originalIn = System.in;
        String simulatedUserInput = "abc" +
                System.getProperty("line.separator") +
                "1";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UserInputAsker userInputAsker = new UserInputAsker();

        // When
        userInputAsker.askUserPositiveInteger("wrongAnswerMessage", 100);

        // Then
        Assert.assertEquals(outContent.toString(), "wrongAnswerMessage" + System.getProperty("line.separator"));

        // Restore the initial input
        System.setIn(originalIn);
        System.setOut(originalOut);
    }
}