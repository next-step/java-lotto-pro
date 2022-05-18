package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoWinner;
import lotto.domain.LottosWinnerCounts;
import lotto.domain.WinnerIndexHelper;

import java.util.Collections;
import java.util.List;

import static lotto.config.LottoGameConfig.LOTTO_GAME_NUMBER_COUNT;

public class LottoWinnerService {

    public LottosWinnerCounts makeLottosResult(List<LottoWinner> winners) {
        LottosWinnerCounts lottosWinnerCounts = new LottosWinnerCounts();
        for (LottoWinner winner : winners) {
            lottosWinnerCounts.reflectResult(winner);
        }
        return lottosWinnerCounts;
    }

    public LottoWinner judge(List<Integer> winnerNumbers, Lotto lotto) {
        Collections.sort(winnerNumbers);
        WinnerIndexHelper indexHelper = new WinnerIndexHelper();

        while (isNotFinish(indexHelper)) {
            Integer winnerNumber = winnerNumbers.get(indexHelper.getWinnerNumberIndex());
            Integer lottoNumber = lotto.lottoNumber(indexHelper.getLottoIndex());
            judgeWinnerNumber(indexHelper, winnerNumber, lottoNumber);
        }

        return judgeLottoWinner(indexHelper.getRightCount());
    }

    boolean isNotFinish(WinnerIndexHelper winnerIndexHelper) {
        return winnerIndexHelper.getWinnerNumberIndex() < LOTTO_GAME_NUMBER_COUNT
                && winnerIndexHelper.getLottoIndex() < LOTTO_GAME_NUMBER_COUNT;
    }

    void judgeWinnerNumber(WinnerIndexHelper indexHelper, Integer winnerNumber, Integer lottoNumber) {
        if (winnerNumber.equals(lottoNumber)) {
            indexHelper.plus1RightCount();
            indexHelper.plus1WinnerNumberIndexAndLottoIndex();
        }
        if (winnerNumber < lottoNumber) {
            indexHelper.plus1WinnerNumberIndex();
        }
        if (winnerNumber > lottoNumber) {
            indexHelper.plus1LottoIndex();
        }
    }

    LottoWinner judgeLottoWinner(int rightCount) {
        return LottoWinner.findLottoWinnerByRightCount(rightCount);
    }
}
