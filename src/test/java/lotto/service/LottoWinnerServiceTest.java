package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoWinner;
import lotto.domain.WinnerIndexHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


class LottoWinnerServiceTest {

    LottoWinnerService lottoWinnerService = new LottoWinnerService();

    @DisplayName("isNotFinish 로직 체크")
    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {
            "1,1,true",
            "2,5,true",
            "5,2,true",
            "1,6,false",
            "6,1,false",
    })
    void isNotFinishTest(int winnerNumberIndex, int lottoNumberIndex, boolean expected) {
        WinnerIndexHelper indexHelper = new WinnerIndexHelper(winnerNumberIndex, lottoNumberIndex, 0);
        boolean result = lottoWinnerService.isNotFinish(indexHelper);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("judgeWinnerNumber winnerNumber가 더 클 때 제대로 동작하는지 체크")
    @Test
    void judgeWinnerNumberTest01() {
        WinnerIndexHelper indexHelper = new WinnerIndexHelper();
        lottoWinnerService.judgeWinnerNumber(indexHelper, 2, 1);
        assertThat(indexHelper.getLottoIndex()).isEqualTo(1);
    }

    @DisplayName("judgeWinnerNumber lottoNumber가 더 클 때 제대로 동작하는지 체크")
    @Test
    void judgeWinnerNumberTest02() {
        WinnerIndexHelper indexHelper = new WinnerIndexHelper();
        lottoWinnerService.judgeWinnerNumber(indexHelper, 1, 2);
        assertThat(indexHelper.getWinnerNumberIndex()).isEqualTo(1);
    }

    @DisplayName("judgeWinnerNumber 두 숫자가 같을 때 제대로 동작하는지 체크")
    @Test
    void judgeWinnerNumberTest03() {
        WinnerIndexHelper indexHelper = new WinnerIndexHelper();
        lottoWinnerService.judgeWinnerNumber(indexHelper, 1, 1);
        assertThat(indexHelper.getLottoIndex()).isEqualTo(1);
        assertThat(indexHelper.getWinnerNumberIndex()).isEqualTo(1);
        assertThat(indexHelper.getRightCount()).isEqualTo(1);
    }

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