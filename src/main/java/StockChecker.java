import model.Product;
import model.UserEligibleProduct;

import java.util.ArrayList;
import java.util.List;

public class StockChecker {
    private final List<Product> productList;
    private final int userMeasurement;

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
                float totalBoxesWithRest = (float) totalPieces / product.getQuantityPerBox();
                int totalBoxes = (int) Math.ceil(totalBoxesWithRest);

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
