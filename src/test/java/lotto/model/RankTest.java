package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @ParameterizedTest(name = "맞춘 갯수가 {0}개이고 보너스 일치 여부가 {2}이면 {1}값을 가진다.")
    @MethodSource("RankProvider")
    void lottoRankFilterTest(int matchCount, Rank expected, boolean matchBonus) {
        // given & when
        Rank actual = Rank.getRank(matchCount, matchBonus);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> RankProvider() {
        return Stream.of(
                Arguments.of(0, Rank.MISS, true),
                Arguments.of(0, Rank.MISS, false),
                Arguments.of(1, Rank.MISS, true),
                Arguments.of(1, Rank.MISS, false),
                Arguments.of(2, Rank.MISS, true),
                Arguments.of(2, Rank.MISS, false),
                Arguments.of(3, Rank.FIFTH, true),
                Arguments.of(3, Rank.FIFTH, false),
                Arguments.of(4, Rank.FOURTH, true),
                Arguments.of(4, Rank.FOURTH, false),
                Arguments.of(5, Rank.THIRD, false),
                Arguments.of(5, Rank.SECOND, true),
                Arguments.of(6, Rank.FIRST, false)
        );
    }

}
