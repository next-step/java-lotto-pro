package step3.model;

public class LottoMoney {

    private final int purchasePrice;
    private static final int LOTTO_PRICE = 1000;
    private static final String INVALID_PRICE_UNIT_MESSAGE = "금액은 1000원 단위로 입력해야합니다";
    private static final String INVALID_MINIMUN_PRICE_MESSAGE = "금액은 최소 1000원이상 입력해야합니다";

    public LottoMoney(int purchasePrice) {
        validatePurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    private void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice < LOTTO_PRICE) throw new IllegalArgumentException(INVALID_MINIMUN_PRICE_MESSAGE);
        if (purchasePrice % LOTTO_PRICE != 0) throw new IllegalArgumentException(INVALID_PRICE_UNIT_MESSAGE);
    }

    public int getSumOfPriceLottos(int size) {
        return size * LOTTO_PRICE;
    }

    public int getCountOfPurchasePrice() {
        return purchasePrice / LOTTO_PRICE;
    }

    public double getPriceRatio(int price) {
        return price / (double) purchasePrice;
    }
}
