import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


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


}
