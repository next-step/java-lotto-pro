package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @ParameterizedTest(name = "맞춘 갯수가 {0}개이면 {1}값을 가진다.")
    @MethodSource("RankProvider")
    void lottoRankFilter(int matchCount, Rank expected) {
        // given & when
        Rank actual = Rank.getRank(matchCount);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> RankProvider() {
        return Stream.of(
                Arguments.of(0, Rank.NONE),
                Arguments.of(1, Rank.NONE),
                Arguments.of(2, Rank.NONE),
                Arguments.of(3, Rank.FOURTH),
                Arguments.of(4, Rank.THIRD),
                Arguments.of(5, Rank.SECOND),
                Arguments.of(6, Rank.FIRST)
        );
    }

}
