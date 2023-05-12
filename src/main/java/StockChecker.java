import model.Product;
import model.UserEligibleProduct;

import java.util.ArrayList;
import java.util.List;

public class StockChecker {
    private List<Product> productList;
    private int userMeasurement;

    public StockChecker(List<Product> productList, int userMeasurement) {
        this.productList = productList;
        this.userMeasurement = userMeasurement;
    }

    public List<UserEligibleProduct> getEligibleProductsForSurface() {
        List<UserEligibleProduct> eligibleProducts = new ArrayList<>();
        productList.forEach(product -> {
            if (product.getUm().equals("box") && product.getPieceUm().equals("cm")) {
                double m2PerPiece = (product.getPieceLength() * product.getPieceWidth()) / 10000.0;
                double m2PerBox = product.getQuantityPerBox() * m2PerPiece;

                int totalPieces = (int) Math.ceil(userMeasurement / m2PerPiece);
                int totalBoxes = (int) Math.ceil(totalPieces / product.getQuantityPerBox());

                if (totalBoxes < product.getQuantity()) {
                    UserEligibleProduct userEligibleProduct = new UserEligibleProduct(
                            product,
                            m2PerPiece,
                            m2PerBox,
                            totalPieces,
                            totalBoxes);
                    eligibleProducts.add(userEligibleProduct);
                }
            }
        });
        return eligibleProducts;
    }
}