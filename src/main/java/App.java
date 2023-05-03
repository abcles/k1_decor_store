public class App {
    static String STOCK_FILE = "file:src/main/resources/stock.json";

    public static void main(String[] args) {
        readStockFromFile(STOCK_FILE);
    }

    public static boolean readStockFromFile(String fileValue) {
        try {
            StockController stockController = new StockController(fileValue);
            stockController.readStockData();
            return true;
        } catch (Exception e) {
            System.out.println("[App][readStockFromFile] Exception: " + e);
            return false;
        }
    }
}
