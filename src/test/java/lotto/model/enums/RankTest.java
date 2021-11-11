package lotto.model.enums;

import static lotto.model.enums.Rank.*;
import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RankTest {
    @ParameterizedTest
    @MethodSource("provideRankAndExpectedResult")
    void valueOf(Rank rank, int countOfMatch, boolean matchBonus) {
        assertThat(rank).isEqualTo(Rank.valueOf(countOfMatch, matchBonus));
    }

    private static Stream<Arguments> provideRankAndExpectedResult() {
        return Stream.of(
            Arguments.of(FIRST, 6, false),
            Arguments.of(SECOND, 5, true),
            Arguments.of(THIRD, 5, false),
            Arguments.of(FIFTH, 3, true),
            Arguments.of(FIFTH, 3, false),
            Arguments.of(MISS, 0, true)
        );
    }
}
