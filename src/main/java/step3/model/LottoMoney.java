package step3.model;

import java.util.List;

public class LottoMoney {

    private final int purchasePrice;
    private static final int LOTTO_PRICE = 1000;
    private static final String INVALID_PRICE_UNIT_MESSAGE = "금액은 1000원 단위로 입력해야합니다";
    private static final String INVALID_MINIMUN_PRICE_MESSAGE = "금액은 최소 1000원이상 입력해야합니다";
    private static final String NOT_ENOUGH_PURCHASE_MONEY = "구매금액이 모자랍니다";

    private final int manualPurchaseCount;
    private final int autoPurchaseCount;

    public LottoMoney(int purchasePrice, int count) {
        validatePurchasePrice(purchasePrice);
        validateManualPurchase(purchasePrice,count);
        this.purchasePrice = purchasePrice;
        this.manualPurchaseCount = count;
        this.autoPurchaseCount = purchasePrice / LOTTO_PRICE - count;
    }

    private void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice < LOTTO_PRICE) throw new IllegalArgumentException(INVALID_MINIMUN_PRICE_MESSAGE);
        if (purchasePrice % LOTTO_PRICE != 0) throw new IllegalArgumentException(INVALID_PRICE_UNIT_MESSAGE);
    }

    private void validateManualPurchase(int purchasePrice, int count) {
        if(purchasePrice < count * LOTTO_PRICE)throw new IllegalArgumentException(NOT_ENOUGH_PURCHASE_MONEY);
    }

    public int getSumOfPriceLottos(int size) {
        return size * LOTTO_PRICE;
    }

    public int getCountOfAutoPurchase() {
        return autoPurchaseCount;
    }

    public double getPriceRatio(int price) {
        return price / (double) purchasePrice;
    }

}
