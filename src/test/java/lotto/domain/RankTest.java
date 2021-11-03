package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest(name = "{0}개를 맞추면 {1}")
    @CsvSource(value = {"6,FIRST","5,SECOND","4,THIRD","3,FOURTH"})
    void 당첨번호_개수에_따라_랭크를_반환한다(int matchCount, Rank rank) {
        assertThat(Rank.rank(matchCount)).isEqualTo(rank);
    }
}