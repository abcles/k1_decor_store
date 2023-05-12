import model.Product;
import model.UserEligibleProduct;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StockCheckerTest {

    @Test
    public void getEligibleProductsWorksCorrectly() {
        // Given
        Product product1 = new Product();
        product1.setProductName("productName1");
        product1.setQuantity(100);
        product1.setUm("box");
        product1.setQuantityPerBox(10);
        product1.setPieceUm("cm");
        product1.setPieceLength(25);
        product1.setPieceWidth(25);

        Product product2 = new Product();
        product2.setProductName("productName2");
        product2.setQuantity(100);
        product2.setUm("box");
        product2.setQuantityPerBox(16);
        product2.setPieceUm("cm");
        product2.setPieceLength(50);
        product2.setPieceWidth(50);

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        int userMeasurement = 10;
        StockChecker stockChecker = new StockChecker(productList, userMeasurement);

        // When
        List<UserEligibleProduct> eligibleProductList = stockChecker.getEligibleProductsForSurface();

        // Then
        Assert.assertEquals(2, eligibleProductList.size());

        Assert.assertEquals(product1, eligibleProductList.get(0).getProduct());
        Assert.assertEquals(0.0625, eligibleProductList.get(0).getM2PerPiece(), 0.0);
        Assert.assertEquals(0.625, eligibleProductList.get(0).getM2PerBox(), 0.0);
        Assert.assertEquals(160, eligibleProductList.get(0).getTotalPieces());
        Assert.assertEquals(16, eligibleProductList.get(0).getTotalBoxes());
        Assert.assertEquals(product2, eligibleProductList.get(1).getProduct());
        Assert.assertEquals(0.25, eligibleProductList.get(1).getM2PerPiece(), 0.0);
        Assert.assertEquals(4, eligibleProductList.get(1).getM2PerBox(), 0.0);
        Assert.assertEquals(40, eligibleProductList.get(1).getTotalPieces());
        Assert.assertEquals(2, eligibleProductList.get(1).getTotalBoxes());
    }
}