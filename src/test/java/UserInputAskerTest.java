import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class UserInputAskerTest {
    @Test
    public void UserIsIntroducingExpectedAnswer() {
        // Giving: Redirect the scanner input
        InputStream originalIn = System.in;

        Integer simulatedUserInput = 1;
        System.setIn(new ByteArrayInputStream(simulatedUserInput.toString().getBytes()));

        UserInputAsker userInputAsker = new UserInputAsker();

        // When
        Integer returnedAnswer = userInputAsker.askUserIntegerInput("wrongAnswerMessage", Arrays.asList(1, 2));

        // Then
        Assert.assertEquals(returnedAnswer, simulatedUserInput);

        // Restore the initial input
        System.setIn(originalIn);
    }

    @Test
    public void UserIsIntroducingUnexpectedResult() {
        // Giving: Redirect the scanner input + console output
        InputStream originalIn = System.in;
        String simulatedUserInput = "9" +
                System.getProperty("line.separator") +
                "1";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UserInputAsker userInputAsker = new UserInputAsker();

        // When
        userInputAsker.askUserIntegerInput("wrongAnswerMessage", Arrays.asList(1, 2));

        // Then
        Assert.assertEquals(outContent.toString(), "wrongAnswerMessage" + System.getProperty("line.separator"));

        // Restore the initial input
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void UserIsIntroducingAlfanumericalResult() {
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
        userInputAsker.askUserIntegerInput("wrongAnswerMessage", Arrays.asList(1, 2));

        // Then
        Assert.assertEquals(outContent.toString(), "wrongAnswerMessage" + System.getProperty("line.separator"));

        // Restore the initial input
        System.setIn(originalIn);
        System.setOut(originalOut);
    }
}