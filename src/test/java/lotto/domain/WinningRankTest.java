package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinningRankTest {

    @DisplayName("맞춘 숫자에 따라 맞는 금액을 주는 지 확인")
    @ParameterizedTest
    @CsvSource(value = { "1:true:0", "3:false:5000", "5:false:1500000", "5:true:30000000" }, delimiter = ':')
    void 당첨금_확인(int matchCount, boolean isMatchBonus, int expected) {
        assertThat(WinningRank.resultRank(matchCount, isMatchBonus).getReward()).isEqualTo(expected);
    }

}
