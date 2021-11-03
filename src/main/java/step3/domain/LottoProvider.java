package step3.domain;

public class LottoProvider {
    private static final int price = 1000;

    private LottoProvider() {
    }

    public static int availableQuantity(int buyAmount) {
        return buyAmount / price;
    }

    public static int totalPurchasePrice(int quantity) {
        return quantity * price;
    }
}
