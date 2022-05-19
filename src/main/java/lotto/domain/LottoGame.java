package lotto.domain;

import lotto.domain.factory.LottoFactory;

import java.util.List;

public class LottoGame {
    private final Lottos lottos;
    private final Money buyPrice;

    private Quantity quantity;

    public LottoGame(String money) {
        this.lottos = new Lottos();
        this.buyPrice = new Money(money);
        this.quantity = new Quantity(this.buyPrice.getQuantity());
    }

    public void buyLottos() {
        validate();
        while (isPurchasable()) {
            this.lottos.add(LottoFactory.createAuto());
            this.quantity = this.quantity.increase();
        }
    }

    private void validate() {
        if (buyPrice.lessThenLottoPrice()) {
            throw new IllegalArgumentException(String.format("금액이 부족합니다.(최소필요금액: %d)", Money.LOTTO_PRICE));
        }
    }

    private boolean isPurchasable() {
        return this.quantity.isPurchasable();
    }

    public int getMaxQuantity() {
        return this.quantity.getMaxQuantity();
    }

    public List<Lotto> getLottos() {
        return this.lottos.getLottos();
    }

    public LottoResult getLottoResult(String winningNumber, String bonusNumber) {
        return lottos.getLottoResult(new WinningNumber(winningNumber, bonusNumber));
    }
}
