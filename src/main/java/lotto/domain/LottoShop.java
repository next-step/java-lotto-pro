package lotto.domain;

import lotto.component.LottoShuffleable;

public class LottoShop {

    private final Money income;

    public LottoShop() {
        this.income = new Money(0);
    }

    public LottoTicket sell(final Money money, final LottoShuffleable lottoShuffleable) {
        earn(money);

        final LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.publish(money, lottoShuffleable);

        return lottoTicket;
    }

    private void earn(final Money money) {
        this.income.earn(money);
    }

    public long countOfSelling() {
        return this.income.get();
    }
}
