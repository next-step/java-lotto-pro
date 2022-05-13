package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @ParameterizedTest(name = "맞힌 숫자가 {0}이면 상금은 {1}이다")
    @CsvSource(value = {"6|2000000000", "5|1500000", "4|50000", "3|5000"}, delimiter = '|')
    void Rank_상금_test(int matchedCount, int prize) {
        assertThat(Rank.getRank(matchedCount).getPrize()).isEqualTo(prize);
    }
}
