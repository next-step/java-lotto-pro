package lotto.domain;

import lotto.domain.factory.LottoFactory;

import java.util.List;

public class LottoGame {
    private final Lottos lottos;
    private final Money money;

    private Quantity quantity;

    public LottoGame(String money) {
        this.lottos = new Lottos();
        this.money = new Money(money);
        this.quantity = new Quantity(this.money.getQuantity());
    }

    public void buyLottos() {
        while (isPurchasable()) {
            this.lottos.add(LottoFactory.createAuto());
            this.quantity = this.quantity.increase();
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

    public LottoResult getLottoResult(String winningNumber) {
        return lottos.getLottoResult(LottoFactory.create(winningNumber));
    }
}
