package model;

import org.junit.Assert;
import org.junit.Test;

import java.text.DecimalFormat;

public class UserEligibleProductTest {

    @Test
    public void toStringWorksCorrectly() {
        // Given
        Product product = new Product();
        product.setProductName("productName");
        product.setQuantity(100);
        product.setUm("box");
        product.setQuantityPerBox(10);
        product.setPieceUm("cm");
        product.setPieceLength(25);
        product.setPieceWidth(25);
        double m2PerPiece = 0.1;
        double m2PerBox = 1;
        int totalPieces = 1000;
        int totalBoxes = 100;
        UserEligibleProduct userEligibleProduct = new UserEligibleProduct(
                product,
                m2PerPiece,
                m2PerBox,
                totalPieces,
                totalBoxes
        );

        // When
        String toStringResult = userEligibleProduct.toString();

        // Then
        String expectedResult = "\r\nEligible product specifications for " + product.getProductName() +
                "\r\n\t product dimensions: " + product.getPieceWidth() + 'x' + product.getPieceLength() + " cmxcm" +
                ", quantity per box: " + product.getQuantityPerBox() +
                ", total quantity in stock: " + product.getQuantity() +
                "\r\n\t cm2/piece: " + (int)(m2PerPiece*10000) +
                ", m2/piece = " + m2PerPiece +
                ", cm2/box = " + (int)(m2PerBox*10000) +
                ", m2/box = " + new DecimalFormat("##.###").format(m2PerBox) +
                "\r\n\t total necessary pieces: " + totalPieces +
                "\r\n\t total necessary boxes: " + totalBoxes;
        Assert.assertEquals(toStringResult, expectedResult);
    }
}