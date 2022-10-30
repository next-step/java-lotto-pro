package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningRanksTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3, 4, 5, 6/1, 2, 3, 4, 5, 6/2000000000",
            "1, 2, 3, 4, 5, 6/1, 2, 3, 4, 5, 7/1500000",
            "1, 2, 3, 4, 5, 6/1, 2, 3, 4, 7, 8/50000",
            "1, 2, 3, 4, 5, 6/1, 2, 3, 7, 8, 9/5000",
            "1, 2, 3, 4, 5, 6/1, 2, 7, 8, 9, 10/0",
            "1, 2, 3, 4, 5, 6/1, 7, 8, 9, 10, 11/0",
            "1, 2, 3, 4, 5, 6/7, 8, 9, 10, 11, 12/0",
    }, delimiter = '/')
    @DisplayName("로또 수익률을 구한다")
    void lotto_calculate_earning_rate(String originNumbers, String winningNumbers, int expect) {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount("1000");
        LottoLottery lottoLottery = lottoPurchaseAmount.toLottoLottery(new ManualNumberGenerator(originNumbers));
        WinningRanks winningRanks = lottoLottery.checkWinningRank(WinningNumbers.of(winningNumbers));
        assertThat(winningRanks.calculateEarningRatio(lottoPurchaseAmount))
                .isEqualTo(Math.floor((double) expect / 1000 * 100) / 100.0);
    }
}
