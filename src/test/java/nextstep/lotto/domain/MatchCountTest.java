package nextstep.lotto.domain;

import nextstep.lotto.domain.MatchCount.LottoWinningPrice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static nextstep.lotto.domain.MatchCount.LottoWinningPrice.MATCH_3_COUNT;
import static nextstep.lotto.domain.MatchCount.LottoWinningPrice.MATCH_4_COUNT;
import static nextstep.lotto.domain.MatchCount.LottoWinningPrice.MATCH_5_BONUS_COUNT;
import static nextstep.lotto.domain.MatchCount.LottoWinningPrice.MATCH_5_COUNT;
import static nextstep.lotto.domain.MatchCount.LottoWinningPrice.MATCH_6_COUNT;

public class MatchCountTest {

    @DisplayName("MatchCount 생성자 테스트")
    @ParameterizedTest
    @MethodSource("provide")
    public void matchCountConstructorTest(LottoWinningPrice index, Integer matchCount, MatchCount given) {

        // when
        MatchCount provide = new MatchCount(index, matchCount);

        // then
        Assertions.assertThat(provide).isEqualTo(given);

    }

    public static Stream<Arguments> provide() {
        return Stream.of(
                Arguments.of(MATCH_3_COUNT, 1, new MatchCount(MATCH_3_COUNT, 1))
        );
    }

    @DisplayName("1등 테스트")
    @ParameterizedTest
    @MethodSource("firstPriceTest")
    public void winningFirstPriceTest(Integer matchCount, Boolean bonusBallContains, LottoWinningPrice expected) {

        // given
        LottoWinningPrice result = LottoWinningPrice.winningPrice(matchCount, bonusBallContains);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    public static Stream<Arguments> firstPriceTest() {
        return Stream.of(
                Arguments.of(6, Boolean.FALSE, MATCH_6_COUNT)
        );
    }

    @DisplayName("2등 테스트")
    @ParameterizedTest
    @MethodSource("secondPriceTest")
    public void winningSecondPriceTest(Integer matchCount, Boolean bonusBallContains, LottoWinningPrice expected) {

        // given
        LottoWinningPrice result = LottoWinningPrice.winningPrice(matchCount, bonusBallContains);

        // then
        Assertions.assertThat(result).isEqualTo(expected);

    }

    public static Stream<Arguments> secondPriceTest() {
        return Stream.of(
                Arguments.of(5, Boolean.TRUE, MATCH_5_BONUS_COUNT)
        );
    }

    @DisplayName("3등 테스트")
    @ParameterizedTest
    @MethodSource("thirdPriceTest")
    public void winningThirdPriceTest(Integer matchCount, Boolean bonusBallContains, LottoWinningPrice expected) {

        // given
        LottoWinningPrice result = LottoWinningPrice.winningPrice(matchCount, bonusBallContains);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    public static Stream<Arguments> thirdPriceTest() {
        return Stream.of(
                Arguments.of(5, Boolean.FALSE, MATCH_5_COUNT),
                Arguments.of(4, Boolean.TRUE, MATCH_5_COUNT)
        );
    }

    @DisplayName("4등 테스트")
    @ParameterizedTest
    @MethodSource("fourthPriceTest")
    public void winningFourthPriceTest(Integer matchCount, Boolean bonusBallContains, LottoWinningPrice expected) {

        // given
        LottoWinningPrice result = LottoWinningPrice.winningPrice(matchCount, bonusBallContains);

        // then
        Assertions.assertThat(result).isEqualTo(expected);

    }

    public static Stream<Arguments> fourthPriceTest() {
        return Stream.of(
                Arguments.of(4, Boolean.FALSE, MATCH_4_COUNT),
                Arguments.of(3, Boolean.TRUE, MATCH_4_COUNT)
        );
    }

    @DisplayName("5등 테스트")
    @ParameterizedTest
    @MethodSource("fifthPriceTest")
    public void winningFifthPriceTest(Integer matchCount, Boolean bonusBallContains, LottoWinningPrice expected) {

        // given
        LottoWinningPrice result = LottoWinningPrice.winningPrice(matchCount, bonusBallContains);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    public static Stream<Arguments> fifthPriceTest() {
        return Stream.of(
                Arguments.of(3, Boolean.FALSE, MATCH_3_COUNT),
                Arguments.of(2, Boolean.TRUE, MATCH_3_COUNT)
        );
    }
}
