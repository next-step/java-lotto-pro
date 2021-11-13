package lotto.domain;

import java.util.List;

public class LottoShop {

    public static final int LOTTO_TICKET_PER_PRICE = 1000;

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public PurchaseCounts countPurchasableLotto(Money purchaseMoney, PurchaseCount manualPurchaseCount) {
        validatePurchaseAmount(purchaseMoney);
        int purchasableCount = purchaseMoney.divide(LOTTO_TICKET_PER_PRICE);
        validateManualPurchaseCount(manualPurchaseCount, purchasableCount);
        return new PurchaseCounts(new PurchaseCount(manualPurchaseCount.gap(purchasableCount)), manualPurchaseCount);
    }

    public static void validatePurchaseAmount(Money purchaseMoney) {
        if (purchaseMoney.isLessThan(LOTTO_TICKET_PER_PRICE)) {
            throw new IllegalArgumentException("로또 1장의 가격은 " + LOTTO_TICKET_PER_PRICE + "원 입니다. (입력값: " + purchaseMoney.getMoney() + ")");
        }
    }

    public LottoTickets createAutoLottoTickets(PurchaseCount purchaseCount) {
        return lottoGenerator.createAutoLottoTickets(purchaseCount);
    }

    public LottoTickets createManualLottoTickets(List<List<Integer>> manualNumbers) {
        return lottoGenerator.createManualLottoTickets(manualNumbers);
    }

    private void validateManualPurchaseCount(PurchaseCount manualPurchaseCount, int purchasableCount) {
        if (manualPurchaseCount.isGreaterThan(purchasableCount)) {
            throw new IllegalArgumentException("수동 구매 갯수는 총 구매 가능 갯수보다 작거나 같아야 합니다. (입력값: " + manualPurchaseCount.getCount() + ")");
        }
    }
}
