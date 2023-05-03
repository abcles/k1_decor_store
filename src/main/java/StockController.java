import com.fasterxml.jackson.databind.ObjectMapper;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class StockController {
    private final String stockFileName;

    public StockController(String stockFileName) {
        this.stockFileName = stockFileName;
    }

    public void readStockData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Product> productList = objectMapper.readValue(
                new URL(stockFileName),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class)
        );
        System.out.println(productList.toString());
    }
}
