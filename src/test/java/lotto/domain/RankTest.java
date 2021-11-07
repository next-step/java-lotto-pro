package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RankTest {

    @DisplayName("당첨번호와 로또번호가 3~6개 사이 일치 일 시 당첨")
    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:false", "2:false", "3:true", "4:true", "5:true", "6:true", "7:false"}, delimiter = ':')
    void prizeTest(int winningNumberSameCount, boolean expectedPrize) {
        Rank rank = Rank.of(winningNumberSameCount);
        boolean prize = rank.isPrize();
        assertThat(prize).isEqualTo(expectedPrize);
    }

    @DisplayName("번호 일치 개수 별 등수")
    @ParameterizedTest
    @MethodSource("rankParametersProvider")
    void rankTest(int winningNumberSameCount, Rank rank) {
        assertThat(Rank.of(winningNumberSameCount)).isEqualTo(rank);
    }

    static Stream<Arguments> rankParametersProvider() {
        return Stream.of(
                arguments(3, Rank.FOURTH_PLACE),
                arguments(4, Rank.THIRD_PLACE),
                arguments(5, Rank.SECOND_PLACE),
                arguments(6, Rank.FIRST_PLACE)
        );
    }
}
