package model;

public class Product {
    private String product;
    private int quantity;
    private String um;
    private int quantityPerBox;
    private String pieceUm;
    private int pieceLength;
    private int pieceWidth;

    public Product() {}

    @Override
    public String toString() {
        return "Product{" +
                "product='" + product + '\'' +
                ", quantity=" + quantity +
                ", um='" + um + '\'' +
                ", quantityPerBox=" + quantityPerBox +
                ", pieceUm='" + pieceUm + '\'' +
                ", pieceLength=" + pieceLength +
                ", pieceWidth=" + pieceWidth +
                '}';
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUm(String um) {
        this.um = um;
    }

    public void setQuantityPerBox(int quantityPerBox) {
        this.quantityPerBox = quantityPerBox;
    }

    public void setPieceUm(String pieceUm) {
        this.pieceUm = pieceUm;
    }

    public void setPieceLength(int pieceLength) {
        this.pieceLength = pieceLength;
    }

    public void setPieceWidth(int pieceWidth) {
        this.pieceWidth = pieceWidth;
    }
}
