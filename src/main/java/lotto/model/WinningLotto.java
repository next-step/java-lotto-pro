package lotto.model;

import java.util.List;

public class WinningLotto {

    private final Lotto lotto;
    private final WinningStatus winningStatus;

    public WinningLotto(List<Integer> numbers) {
        this.lotto = new Lotto(numbers);
        this.winningStatus = new WinningStatus();
    }

    public void compareWinningLotto(Lotto lotto) {
        int count = lotto.compareLottoAndReturnMatchCount(this.lotto);

        winningStatus.recordResults(count);
    }

    public int findWinningCount(MatchPoint matchPoint) {
        return winningStatus.findWinningCount(matchPoint);
    }

    public double findEarningsRate(long lottosTotalPrice) {
        return  winningStatus.findEarningsRate(lottosTotalPrice);
    }
}
