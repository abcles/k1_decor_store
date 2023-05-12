import lombok.NonNull;
import model.Product;

import java.util.Collections;
import java.util.List;

public class App {
    static String STOCK_FILE = "file:src/main/resources/stock.json";

    public static void main(String[] args) {
        sayWelcome();
        List<Product> productList = readStockFromFile(STOCK_FILE);
        int userMeasurement = readUserMeasurement(new UserInputAsker());

        displayAvailableMaterialForSurface(productList, userMeasurement);
    }

    public static void sayWelcome() {
        System.out.println("Welcome to our store, the place where your dreams came true");
    }

    public static List<Product> readStockFromFile(String fileValue) {
        try {
            StockReader stockReader = new StockReader(fileValue);
            stockReader.readStockData();
            return stockReader.getProductList();
        } catch (Exception e) {
            System.err.println("[App][readStockFromFile] Exception: " + e);
            return Collections.emptyList();
        }
    }

    public static int readUserMeasurement(@NonNull UserInputAsker userInputAsker) {
        System.out.println("What surface do you want to cover (as m2)?");
        return userInputAsker.askUserPositiveInteger(
                "Only positive integers and less than 1000 are accepted. Try once again: ",
                1000
        );
    }

    public static void displayAvailableMaterialForSurface(List<Product> productList, int userMeasurement) {
        System.out.println("Let's see if any material is suitable for you!");
        StockChecker stockChecker = new StockChecker(productList, userMeasurement);
        System.out.println(stockChecker.getEligibleProductsForSurface());
    }

}
