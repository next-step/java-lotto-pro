package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RankTest {

    @ParameterizedTest(name = "{0}개를 맞추면 {1}")
    @CsvSource(value = {"6,FIRST", "5,SECOND", "4,THIRD", "3,FOURTH"})
    void 당첨번호_개수에_따라_랭크를_반환한다(int matchCount, Rank rank) {
        assertThat(Rank.rank(matchCount)).isEqualTo(rank);
    }

    @ParameterizedTest(name = "{0}개를 맞추면 NO_MATCH")
    @ValueSource(ints = {2, 1, 0})
    void 당첨번호가_3개보다_작으면_NO_MATCH_반환한다(int matchCount) {
        assertThat(Rank.rank(matchCount)).isEqualTo(Rank.NO_MATCH);
    }

    @ParameterizedTest(name = "{0}개를 맞추면 NO_MATCH")
    @ValueSource(ints = {-1, 7})
    void 당첨번호가_범위에_없으면_에러를_발생한다(int matchCount) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Rank.rank(matchCount));
    }
}