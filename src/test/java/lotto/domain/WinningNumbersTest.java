package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @Test
    @DisplayName("당첨 결과를 반환")
    void check_winning_rank() {
        WinningNumbers winningNumbers = WinningNumbers.of("1, 2, 3, 4, 5, 6");
        LottoNumbers lottoNumbers = LottoNumbers.of(new ManualNumberGenerator("1, 2, 3, 4, 35, 45"));
        assertThat(winningNumbers.checkWinningRank(lottoNumbers)).isEqualTo(WinningRank.MATCH_FOUR);
    }
}