package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @ParameterizedTest
    @CsvSource(value = {"FOURTH:3", "THIRD:4", "SECOND:5", "FIRST:6"}, delimiter = ':')
    void testRank(Rank rank, int matchedCount) {
        assertThat(Rank.of(matchedCount)).isEqualTo(rank);
    }
}
