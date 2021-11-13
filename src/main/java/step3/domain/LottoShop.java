package step3.domain;

public class LottoShop {

    private final Money income;

    public LottoShop() {
        this.income = new Money(0);
    }

    public LottoTicket sell(final Money money) {
        earn(money);

        final LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.publish(money);

        return lottoTicket;
    }

    private void earn(final Money money) {
        this.income.earn(money);
    }

    public int countOfSelling() {
        return this.income.get();
    }
}
