import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AppTest {

    @Test
    public void testWelcomeMessageIsPrinted() {
        // Giving: Redirect the console output
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // When
        App.sayWelcome();

        // Then
        Assert.assertTrue(outContent.toString().contains("Welcome to our store, the place where your dreams came true"));

        // Restore the initial output for console
        System.setOut(originalOut);
    }

    @Test
    public void testReadStockCorrectly() {
        Assert.assertTrue(App.readStockFromFile("file:src/main/resources/stock.json"));
    }

    @Test
    public void testReadStockWithException() {
        // Giving: Redirect the console error
        PrintStream originalErr = System.err;
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();

        System.setErr(new PrintStream(errContent));

        // When
        boolean isStockRead = App.readStockFromFile("file:src");

        // Then
        Assert.assertFalse(isStockRead);
        Assert.assertTrue(errContent.toString().equals("[App][readStockFromFile] Exception: java.io" +
                ".FileNotFoundException: src (Access is denied)\r\n"));

        // Restore the initial output for console
        System.setOut(originalErr);
    }

    @Test
    public void testReadUserMeasurementCorrectly() {
        // Given
        UserInputAsker mockUserInputAsker = mock(UserInputAsker.class);
        when(mockUserInputAsker.askUserIntegerInput(
                "Only 1 or 2 are acceptable answers. Try once again: ",
                Arrays.asList(1, 2))
        ).thenReturn(1);

        // Redirect the console output
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // When
        int userMeasurement = App.readUserMeasurement(mockUserInputAsker);

        // Then
        Assert.assertTrue(outContent.toString().contains("What surface do you want to cover (1 - width & length; 2 - m2)?"));
        Assert.assertEquals(userMeasurement, 1);

        // Restore the initial output for console
        System.setOut(originalOut);
    }
}
