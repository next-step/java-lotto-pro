package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("순위 테스트")
class RankTests {

    @ParameterizedTest
    @MethodSource("rankProvider")
    @DisplayName("순위를 계산한다")
    void should_RankReturn(int matcheCount, boolean isMatcheBonus, Rank expected) {
        Rank actual = Rank.valueOf(matcheCount, isMatcheBonus);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> rankProvider() {
        return Stream.of(
            Arguments.of(6, false, Rank.ONE),
            Arguments.of(5, true, Rank.TWO),
            Arguments.of(5, false, Rank.THREE),
            Arguments.of(4, false, Rank.FOUR),
            Arguments.of(3, false, Rank.FIVE),
            Arguments.of(0, false, Rank.MISS)
        );
    }
}
