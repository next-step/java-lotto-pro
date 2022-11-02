package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RankTest {

    @ParameterizedTest(name = "{displayName} - rank: {0}, countOfMatch: {1}, bonusMatch: {2}")
    @MethodSource("rankProvider")
    @DisplayName("Rank 값 생성 테스트")
    public void test(Rank rank, int countOfMatch, boolean bonusMatch) {
        assertThat(rank).isEqualTo(Rank.valueOf(countOfMatch, bonusMatch));
    }

    private static Stream<Arguments> rankProvider() {
        return Stream.of(
                Arguments.of(Rank.MISS, 0, false),
                Arguments.of(Rank.FIFTH, 3, false),
                Arguments.of(Rank.FOURTH, 4, false),
                Arguments.of(Rank.THIRD, 5, false),
                Arguments.of(Rank.SECOND, 5, true),
                Arguments.of(Rank.FIRST, 6, false)
        );
    }
}
