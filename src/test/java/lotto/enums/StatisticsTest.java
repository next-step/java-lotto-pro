package lotto.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static lotto.enums.Statistics.getRank;
import static org.assertj.core.api.Assertions.assertThat;

class StatisticsTest {

    @ParameterizedTest
    @DisplayName("일치하는 개수에 따라 적절한 랭킹을 리턴하는지 확인한다.")
    @CsvSource({"6, FIRST", "5, SECOND", "4, THIRD", "3, FOURTH", "2, LOSE", "1, LOSE", "0, LOSE"})
    void test(int numberOfMatch, Statistics expected) {
        assertThat(getRank(numberOfMatch))
                .isEqualTo(expected);
    }

}