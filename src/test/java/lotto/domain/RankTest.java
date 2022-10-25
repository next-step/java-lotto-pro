package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("당첨 개수에 따른 당첨 금액 조회 성공")
    @ParameterizedTest(name = "{index} ) {displayName} [{arguments}]")
    @CsvSource(value = {"6>2000000000", "5>1500000", "4>50000", "3>5000", "2>0", "1>0", "0>0"}, delimiter = '>')
    public void valueOf(int countOfMatch, int winningMoney) {
        assertThat(Rank.valueOf(countOfMatch).getWinningMoney()).isEqualTo(winningMoney);
    }
}
