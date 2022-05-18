package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosWinnerCountsTest {

    @DisplayName("lottosWinnerCounts 생성시 results map이 Winner 객체 key가 포함되는지 확인")
    @Test
    void lottosWinnerCountsTest() {
        LottosWinnerCounts lottosWinnerCounts = new LottosWinnerCounts();
        for (LottoWinner winner : LottoWinner.values()) {
            assertThat(lottosWinnerCounts.winnerCount(winner))
                    .isNotNull()
                    .isEqualTo(0);
        }
    }

    @DisplayName("lottosWinnerCountsTest reflectResult 함수가 잘 반영되는지 확인")
    @Test
    void reflectResultTest() {
        LottosWinnerCounts lottosWinnerCounts = new LottosWinnerCounts();
        lottosWinnerCounts.reflectResult(LottoWinner.FIRST);
        assertThat(lottosWinnerCounts.winnerCount(LottoWinner.FIRST))
                .isEqualTo(1);
    }
}