package lotto.model;

public class WinningLotto {

    private final LottoNumbers lottoNumbers;
    private final WinningStatus winningStatus;

    public WinningLotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.winningStatus = new WinningStatus();
    }

    public void compareWinningLottoNumbers(LottoNumbers lottoNumbers) {
        int count = 0;

        for (LottoNumber number : lottoNumbers.getNumbers()) {
            count = count + compareNumberAndReturnAddCount(number);
        }

        winningStatus.recordResults(count);
    }

    private int compareNumberAndReturnAddCount(LottoNumber number) {
        if(this.lottoNumbers.getNumbers().contains(number)) {
            return 1;
        }

        return 0;
    }

    protected int getWinningCount(MatchPoint matchPoint) {
        return winningStatus.getWinningCount(matchPoint);
    }
}
