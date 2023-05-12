import model.Product;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AppTest {

    @Test
    public void welcomeMessageIsPrinted() {
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
    public void readStockCorrectly() {
        Assert.assertTrue(App.readStockFromFile("file:src/main/resources/stock.json").size() > 0);
    }

    @Test
    public void readStockWithException() {
        // Giving: Redirect the console error
        PrintStream originalErr = System.err;
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();

        System.setErr(new PrintStream(errContent));

        // When
        List<Product> stockRead = App.readStockFromFile("file:src");

        // Then
        Assert.assertFalse(stockRead.size() > 0);
        Assert.assertEquals("[App][readStockFromFile] Exception: java.io" +
                ".FileNotFoundException: src (Access is denied)\r\n", errContent.toString());

        // Restore the initial output for console
        System.setOut(originalErr);
    }

    @Test
    public void readUserMeasurementCorrectly() {
        // Given
        UserInputAsker mockUserInputAsker = mock(UserInputAsker.class);
        when(mockUserInputAsker.askUserPositiveInteger(
                "Only positive integers and less than 1000 are accepted. Try once again: ",
                1000)
        ).thenReturn(10);

        // Redirect the console output
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // When
        int userMeasurement = App.readUserMeasurement(mockUserInputAsker);

        // Then
        Assert.assertTrue(outContent.toString().contains("What surface do you want to cover (as m2)?"));
        Assert.assertEquals(userMeasurement, 10);

        // Restore the initial output for console
        System.setOut(originalOut);
    }

    @Test
    public void startSearchingForMaterialMessageIsPrinted() {
        // Giving: Redirect the console output
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // When
        App.displayAvailableMaterialForSurface(Collections.emptyList(), 1);

        // Then
        Assert.assertTrue(outContent.toString().contains("Let's see if any material is suitable for you!"));

        // Restore the initial output for console
        System.setOut(originalOut);
    }
}
