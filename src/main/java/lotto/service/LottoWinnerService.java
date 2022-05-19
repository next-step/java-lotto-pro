package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoWinner;
import lotto.domain.LottosWinnerCounts;

import java.util.Collections;
import java.util.List;

public class LottoWinnerService {

    public LottosWinnerCounts makeLottosWinnerCounts(List<LottoWinner> winners) {
        LottosWinnerCounts lottosWinnerCounts = new LottosWinnerCounts();
        for (LottoWinner winner : winners) {
            lottosWinnerCounts.reflectResult(winner);
        }
        return lottosWinnerCounts;
    }

    public LottoWinner judge(List<Integer> winnerNumbers, Lotto lotto) {
        Collections.sort(winnerNumbers);
        return lotto.judge(winnerNumbers);
    }

    LottoWinner judgeLottoWinner(int rightCount) {
        return LottoWinner.findLottoWinnerByRightCount(rightCount);
    }
}
