import model.Product;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.List;

public class StockControllerTest {

    @Test
    public void StockIsReadSuccessfully(){
        String STOCK_FILE = "file:src/main/resources/stock.json";
        StockController stockController = new StockController(STOCK_FILE);
        try {
            stockController.readStockData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Product> productList = stockController.getProductList();
        Assert.assertTrue(productList.get(0).getProduct().equals("Tiles Alexia"));
    }

    @Test(expected = FileNotFoundException.class)
    public void StockIsNotReadSuccessfully() throws IOException {
        String STOCK_FILE = "file:src/main/resources/stockFake.json";

        StockController stockController = new StockController(STOCK_FILE);
        stockController.readStockData();
    }
}
