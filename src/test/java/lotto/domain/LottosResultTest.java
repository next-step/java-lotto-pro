package lotto.domain;

import lotto.config.LottoGameConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosResultTest {

    @DisplayName("5개 구입해서 4등이 한번 된 경우에 LottosResult 가 제대로 만들어지는지 확인 ")
    @Test
    void lottosResultTest01() {
        int count = 5;
        List<LottoWinner> winnerList = Arrays.asList(LottoWinner.FORTH);
        LottosWinnerCounts lottosWinnerCounts = new LottosWinnerCounts(winnerList);

        LottosResult lottosResult = new LottosResult(count * LottoGameConfig.PURCHASE_MONEY, lottosWinnerCounts);
        assertThat(lottosResult.ratio())
                .isEqualTo(1.0f);
    }

    @DisplayName("4개 구입해서 1,2,3,4 등이 각각 한번씩 된 경우에 LottosResult 가 제대로 만들어지는지 확인 ")
    @Test
    void lottosResultTest02() {
        int count = 4;
        List<LottoWinner> winnerList = Arrays.asList(LottoWinner.FIRST, LottoWinner.SECOND, LottoWinner.THIRD, LottoWinner.FORTH);
        LottosWinnerCounts lottosWinnerCounts = new LottosWinnerCounts(winnerList);

        float expectedRatio = (LottoWinner.FIRST.getWinnerMoney() +
                LottoWinner.SECOND.getWinnerMoney() +
                LottoWinner.THIRD.getWinnerMoney() +
                LottoWinner.FORTH.getWinnerMoney()) / (float) (count * LottoGameConfig.PURCHASE_MONEY);

        LottosResult lottosResult = new LottosResult(count * LottoGameConfig.PURCHASE_MONEY, lottosWinnerCounts);
        assertThat(lottosResult.ratio())
                .isEqualTo(expectedRatio);
    }
}