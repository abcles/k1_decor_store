import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class StockControllerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void StockIsReadSuccessfully(){
        String STOCK_FILE = "file:src/main/resources/stock.json";

        try {
            StockController stockController = new StockController(STOCK_FILE);
            stockController.readStockData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(outContent.toString().contains("Tiles Alexia"));
    }

    @Test(expected = FileNotFoundException.class)
    public void StockIsNotReadSuccessfully() throws IOException {
        String STOCK_FILE = "file:src/main/resources/stockFake.json";

        try {
            StockController stockController = new StockController(STOCK_FILE);
            stockController.readStockData();
        } catch (IOException e) {
            throw e;
        }
    }
}
