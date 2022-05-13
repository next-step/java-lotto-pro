package lotto.model;

public class WinningLotto {

    private final Lotto lotto;
    private final WinningStatus winningStatus;

    public WinningLotto(LottoNumbers lottoNumbers) {
        this.lotto = new Lotto(lottoNumbers);
        this.winningStatus = new WinningStatus();
    }

    public void compareWinningLotto(Lotto lotto) {
        int count = lotto.compareLottoAndReturnMatchCount(this.lotto);

        winningStatus.recordResults(count);
    }

    protected int findWinningCount(MatchPoint matchPoint) {
        return winningStatus.findWinningCount(matchPoint);
    }

    public double findEarningsRate(long lottosTotalPrice) {
        return  winningStatus.findEarningsRate(lottosTotalPrice);
    }
}
