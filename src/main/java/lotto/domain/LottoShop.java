package lotto.domain;

public class LottoShop {

    public static final int LOTTO_TICKET_PER_PRICE = 1000;

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public int getPurchasableLottoTicketCount(Money purchaseMoney) {
        validatePurchaseAmount(purchaseMoney);
        return purchaseMoney.divide(LOTTO_TICKET_PER_PRICE);
    }

    public LottoTickets createLottoTickets(PurchaseCount purchaseCount) {
        return lottoGenerator.createLottoTickets(purchaseCount);
    }

    private void validatePurchaseAmount(Money purchaseMoney) {
        if (purchaseMoney.isLessThan(LOTTO_TICKET_PER_PRICE)) {
            throw new IllegalArgumentException("로또 1장의 가격은 " + LOTTO_TICKET_PER_PRICE + "원 입니다. (입력값: " + purchaseMoney.getMoney() + ")");
        }
    }
}
