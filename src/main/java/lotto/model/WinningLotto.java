package lotto.model;

public class WinningLotto {

    private final Lotto lotto;
    //private final LottoNumbers lottoNumbers;
    private final WinningStatus winningStatus;

    public WinningLotto(LottoNumbers lottoNumbers) {
        //this.lottoNumbers = lottoNumbers;
        this.lotto = new Lotto(lottoNumbers);
        this.winningStatus = new WinningStatus();
    }

    public void compareWinningLotto(Lotto lotto) {
        int count = lotto.compareLottoAndReturnMatchCount(this.lotto);

        winningStatus.recordResults(count);
    }

    protected int getWinningCount(MatchPoint matchPoint) {
        return winningStatus.getWinningCount(matchPoint);
    }
}
