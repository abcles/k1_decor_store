import org.junit.Assert;
import org.junit.Test;


public class AppTest {


    @Test
    public void testStartWithGoodData() {
        Assert.assertTrue(App.readStockFromFile("file:src/main/resources/stock.json"));
    }

    @Test
    public void testStartWithException() {
        Assert.assertFalse(App.readStockFromFile("file:src"));
    }

}
