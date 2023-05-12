import com.fasterxml.jackson.databind.ObjectMapper;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

public class StockReader {
    private final String stockFileName;

    private List<Product> productList;

    public StockReader(String stockFileName) {
        this.stockFileName = stockFileName;
    }

    public void readStockData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        this.productList = objectMapper.readValue(
                new URL(stockFileName),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class)
        );
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }
}
