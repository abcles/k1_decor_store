package model;

import lombok.Data;

@Data
public class Product {
    private String productName = "";
    private int quantity = 0;
    private String um = "";
    private int quantityPerBox = 0;
    private String pieceUm = "";
    private int pieceLength = 0;
    private int pieceWidth = 0;

    public Product() {}

}
