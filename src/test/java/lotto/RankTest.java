package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RankTest {

    static Stream<Arguments> rank_value_test() {
        return Stream.of(
                Arguments.of(Rank.valueOf(0,true), Rank.MISS),
                Arguments.of(Rank.valueOf(0,false), Rank.MISS),
                Arguments.of(Rank.valueOf(1,true), Rank.MISS),
                Arguments.of(Rank.valueOf(1,false), Rank.MISS),
                Arguments.of(Rank.valueOf(2,true), Rank.MISS),
                Arguments.of(Rank.valueOf(2,false), Rank.MISS),
                Arguments.of(Rank.valueOf(3,true), Rank.FIFTH),
                Arguments.of(Rank.valueOf(3,false), Rank.FIFTH),
                Arguments.of(Rank.valueOf(4,true), Rank.FOURTH),
                Arguments.of(Rank.valueOf(4,false), Rank.FOURTH),
                Arguments.of(Rank.valueOf(5,true), Rank.SECOND),
                Arguments.of(Rank.valueOf(5,false), Rank.THIRD),
                Arguments.of(Rank.valueOf(6,true), Rank.FIRST),
                Arguments.of(Rank.valueOf(6,false), Rank.FIRST)
        );
    }

    @ParameterizedTest
    @DisplayName("랭크가 경우의 수에 따라 순위가 적절히 매겨지는지 확인")
    @MethodSource
    void rank_value_test(Rank input, Rank expected) {
        assertThat(input).isEqualTo(expected);
    }
}
