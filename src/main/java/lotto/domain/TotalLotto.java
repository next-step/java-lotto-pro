package lotto.domain;

public class TotalLotto {

    private Money money;

    private Lottos lottoList;

    private TotalLotto(Money money, Lottos lottoList) {
        this.money = money;
        this.lottoList = lottoList;
    }

    public static TotalLotto from(int amount) {
        Money money = Money.from(amount);
        Lottos lottoList = LottoShop.generateLottos(money.getCount());
        return new TotalLotto(money, lottoList);
    }

    public int getCount() {
        return this.money.getCount();
    }

    public String lottoListToString() {
        StringBuilder sb = new StringBuilder();
        this.lottoList.getLottoList().stream()
                .forEach(lotto -> sb.append(lotto.toString() + "\n"));
        return sb.toString();
    }

    public LottoScore getLottoScore(WinningLotto winningLotto) {
        return new LottoScore(this.lottoList.matchLottoStaticToString(winningLotto));
    }
}
