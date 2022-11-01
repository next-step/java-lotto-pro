package lotto.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @MethodSource("rankParam")
    @DisplayName("Rank enum 의 등수 반환 테스트")
    public void rankValueOfTest(int countOfMatch, boolean matchBonus, Rank expected) {
        assertThat(Rank.valueOf(countOfMatch, matchBonus)).isEqualTo(expected);
    }

    static Stream<Arguments> rankParam() {
        return Stream.of(Arguments.of(6, true, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(2, true, Rank.MISS)
        );
    }
}