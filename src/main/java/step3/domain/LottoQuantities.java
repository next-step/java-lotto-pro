package step3.domain;

public class LottoQuantities {
    private static final int LOTTO_PRICE = 1000;
    private final LottoQuantity manualLottoQuantity;
    private final LottoQuantity autoLottoQuantity;

    private LottoQuantities(LottoQuantity manualQuantity, LottoQuantity autoQuantity) {
        this.manualLottoQuantity = manualQuantity;
        this.autoLottoQuantity = autoQuantity;
    }

    public static LottoQuantities of(int budget, int manualQuantity) {
        validateBudget(budget, manualQuantity);
        int totalQuantity = budget / LOTTO_PRICE;
        return new LottoQuantities(new LottoQuantity(manualQuantity), new LottoQuantity(totalQuantity - manualQuantity));
    }

    public int getManualLottoQuantity() {
        return manualLottoQuantity.getQuantity();
    }

    public int getAutoLottoQuantity() {
        return autoLottoQuantity.getQuantity();
    }

    private static void validateBudget(int budget, int manualQuantity ) {
        int minBudget = LOTTO_PRICE * manualQuantity;
        if (budget < minBudget) {
            throw new IllegalArgumentException("구매 금액은 " + minBudget + " 이상이어야 합니다.");
        }
    }
}
