package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoWinner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


class LottoWinnerServiceTest {

    LottoWinnerService lottoWinnerService = new LottoWinnerService();

    @DisplayName("judgeLottoWinner Winner enum을 제대로 리턴하는지 확인")
    @Test
    void judgeLottoWinnerTest() {
        assertThat(lottoWinnerService.judgeLottoWinner(0))
                .isEqualTo(LottoWinner.NOT_WINNER);
        assertThat(lottoWinnerService.judgeLottoWinner(1))
                .isEqualTo(LottoWinner.NOT_WINNER);
        assertThat(lottoWinnerService.judgeLottoWinner(2))
                .isEqualTo(LottoWinner.NOT_WINNER);
        assertThat(lottoWinnerService.judgeLottoWinner(3))
                .isEqualTo(LottoWinner.FORTH);
        assertThat(lottoWinnerService.judgeLottoWinner(4))
                .isEqualTo(LottoWinner.THIRD);
        assertThat(lottoWinnerService.judgeLottoWinner(5))
                .isEqualTo(LottoWinner.SECOND);
        assertThat(lottoWinnerService.judgeLottoWinner(6))
                .isEqualTo(LottoWinner.FIRST);
    }

    @DisplayName("judge 1등을 잘 맞추는가?")
    @Test
    void judgeTest01() {
        LottoWinner winner = lottoWinnerService.judge(Arrays.asList(1, 2, 3, 4, 5, 6),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(winner).isEqualTo(LottoWinner.FIRST);
    }

    @DisplayName("judge 4등을 잘 맞추는가?")
    @Test
    void judgeTest02() {
        LottoWinner winner = lottoWinnerService.judge(Arrays.asList(1, 2, 3, 4, 5, 6),
                new Lotto(Arrays.asList(1, 2, 3, 14, 15, 16)));
        assertThat(winner).isEqualTo(LottoWinner.FORTH);
    }

    @DisplayName("judge NOT_WINNER 을 잘 맞추는가?")
    @Test
    void judgeTest03() {
        LottoWinner winner = lottoWinnerService.judge(Arrays.asList(1, 2, 3, 4, 5, 6),
                new Lotto(Arrays.asList(1, 2, 13, 14, 15, 16)));
        assertThat(winner).isEqualTo(LottoWinner.NOT_WINNER);
    }
}