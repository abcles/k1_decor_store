package model;

import java.text.DecimalFormat;

public class UserEligibleProduct {

    private Product product;
    private double m2PerPiece;
    private double m2PerBox;
    private int totalPieces;
    private int totalBoxes;

    public UserEligibleProduct(Product product,
                               double m2PerPiece,
                               double m2PerBox,
                               int totalPieces,
                               int totalBoxes
    ) {
        this.product = product;
        this.m2PerPiece = m2PerPiece;
        this.m2PerBox = m2PerBox;
        this.totalPieces = totalPieces;
        this.totalBoxes = totalBoxes;
    }

    public Product getProduct() {
        return product;
    }

    public double getM2PerPiece() {
        return m2PerPiece;
    }

    public double getM2PerBox() {
        return m2PerBox;
    }

    public int getTotalPieces() {
        return totalPieces;
    }

    public int getTotalBoxes() {
        return totalBoxes;
    }

    @Override
    public String toString() {
        return "\r\nEligible product specifications for " + product.getProductName() +
                "\r\n\t product dimensions: " + product.getPieceWidth() + 'x' + product.getPieceLength() + " cmxcm" +
                ", quantity per box: " + product.getQuantityPerBox() +
                ", total quantity in stock: " + product.getQuantity() +
                "\r\n\t cm2/piece: " + (int)(m2PerPiece*10000) +
                ", m2/piece = " + m2PerPiece +
                ", cm2/box = " + (int)(m2PerBox*10000) +
                ", m2/box = " + new DecimalFormat("##.###").format(m2PerBox) +
                "\r\n\t total necessary pieces: " + totalPieces +
                "\r\n\t total necessary boxes: " + totalBoxes;
    }
}
