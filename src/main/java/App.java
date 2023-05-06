public class App {
    static String STOCK_FILE = "file:src/main/resources/stock.json";

    public static void main(String[] args) {
        sayWelcome();
        readStockFromFile(STOCK_FILE);
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


}
