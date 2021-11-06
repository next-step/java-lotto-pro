package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinningRankTest {

    @DisplayName("맞춘 숫자에 따라 맞는 금액을 주는 지 확인")
    @ParameterizedTest
    @CsvSource(value = { "0:0", "1:0", "3:5000", "4:50000", "5:1500000", "6:2000000000" }, delimiter = ':')
    void 당첨금_확인(int matchCount, int expected) {
        assertThat(WinningRank.resultRank(matchCount).getReward()).isEqualTo(expected);
    }

}
