package lotto.domain;

public class TotalLotto {

    private Money money;

    private Lottos lottoList;

    public static TotalLotto from(int amount) {
        TotalLotto totalLotto = new TotalLotto();
        totalLotto.money = Money.from(amount);

        totalLotto.lottoList = new Lottos();
        totalLotto.lottoList.autoGenerator(totalLotto.money.getCount());
        return totalLotto;
    }

    public int getCount() {
        return this.money.getCount();
    }

    public Lottos getLottoList() {
        return this.lottoList;
    }

    public String lottoListToString() {
        StringBuilder sb = new StringBuilder();
        this.lottoList.getLottoList().stream()
                .forEach(lotto -> sb.append(lotto.toString() + "\n"));
        return sb.toString();
    }
}
