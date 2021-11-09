package step3.domain;

public class LottoShop {

    private final Money money;

    public LottoShop() {
        this.money = new Money(0);
    }

    public LottoTicket sell(final Money money) {
        earn(money);

        final LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.publish(money);

        return lottoTicket;
    }

    public Money income() {
        return this.money;
    }

    private void earn(final Money money) {
        this.money.earn(money);
    }
}
