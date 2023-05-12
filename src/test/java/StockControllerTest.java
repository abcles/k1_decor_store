import model.Product;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.List;

public class StockControllerTest {

    @Test
    public void stockIsReadSuccessfully(){
        String STOCK_FILE = "file:src/main/resources/stock.json";
        StockReader stockReader = new StockReader(STOCK_FILE);
        try {
            stockReader.readStockData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Product> productList = stockReader.getProductList();
        Assert.assertTrue(productList.get(0).getProductName().equals("Tiles Alexia"));
    }

    @Test(expected = FileNotFoundException.class)
    public void stockIsNotReadSuccessfully() throws IOException {
        String STOCK_FILE = "file:src/main/resources/stockFake.json";

        StockReader stockReader = new StockReader(STOCK_FILE);
        stockReader.readStockData();
    }
}
