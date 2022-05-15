package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @ParameterizedTest(name = "맞힌 숫자가 {0}이고 보너스 볼이 {1}이면 상금은 {2}이다")
    @CsvSource(value = {"6|false|2000000000", "5|true|30000000", "5|false|1500000", "4|false|50000", "3|false|5000"},
            delimiter = '|')
    void Rank_상금_test(int countOfMatch, boolean matchBonus, int winningMoney) {
        assertThat(Rank.valueOf(countOfMatch, matchBonus).getWinningMoney()).isEqualTo(winningMoney);
    }
}
