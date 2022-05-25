package lotto.domain;

public class TotalLotto {
    private static final String INPUT_ERROR = "잘못된 값을 입력하였습니다.";

    private Money money;

    private Lottos lottoList;

    private TotalLotto(Money money, Lottos lottoList) {
        this.money = money;
        this.lottoList = lottoList;
    }

    public static TotalLotto of(Money money, Lottos lottoList) {
        validGenerateCount(money.getAllCount(), lottoList.getCount());
        return new TotalLotto(money, lottoList);
    }

    public int getCount() {
        return this.money.getAllCount();
    }

    private static void validGenerateCount(int moneyCount, int lottoListCount) {
        if (moneyCount != lottoListCount) {
            throw new IllegalArgumentException(INPUT_ERROR);
        }
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
