import lombok.NonNull;

import java.util.Arrays;

public class App {
    static String STOCK_FILE = "file:src/main/resources/stock.json";

    public static void main(String[] args) {
        sayWelcome();
        readStockFromFile(STOCK_FILE);
        System.out.println(readUserMeasurement(new UserInputAsker()));
    }

    public static void sayWelcome() {
        System.out.println("Welcome to our store, the place where your dreams came true");
    }

    public static boolean readStockFromFile(String fileValue) {
        try {
            StockController stockController = new StockController(fileValue);
            stockController.readStockData();
            return true;
        } catch (Exception e) {
            System.err.println("[App][readStockFromFile] Exception: " + e);
            return false;
        }
    }

    public static int readUserMeasurement(@NonNull UserInputAsker userInputAsker) {
        System.out.println("What surface do you want to cover (1 - width & length; 2 - m2)?");
        return userInputAsker.askUserIntegerInput(
                "Only 1 or 2 are acceptable answers. Try once again: ",
                Arrays.asList(1, 2)
        );
    }

}
