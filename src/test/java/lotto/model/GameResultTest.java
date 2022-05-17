package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameResultTest {

    @ParameterizedTest(name = "사용자의 로또 번호와 당첨 번호를 비교하여 1등부터 4등까지의 갯수를 가진다")
    @MethodSource("GameResultProvider")
    void calculateRankTest(String winnersLotteryInput, String userLotteryInput, Rank rank) {
        // given
        Lotto winnersLotto = new Lotto(new InputNumberGenerator(winnersLotteryInput));
        Lotto userLotto = new Lotto(new InputNumberGenerator(userLotteryInput));
        GameResult gameResult = new GameResult();

        // when
        gameResult.calculateRank(winnersLotto, userLotto);
        long actual = gameResult.gameResult().get(rank);

        // then
        assertThat(actual).isEqualTo(1L);
    }

    @ParameterizedTest(name = "게임 결과 객체는 수익률을 반환한다")
    @MethodSource("benefitResultProvider")
    void benefitResultTest(String winnersLotteryInput, String userLotteryInput, double deposit, double expected) {
        // given
        Lotto winnersLotto = new Lotto(new InputNumberGenerator(winnersLotteryInput));
        Lotto userLotto = new Lotto(new InputNumberGenerator(userLotteryInput));
        GameResult gameResult = new GameResult();

        // when
        gameResult.calculateRank(winnersLotto, userLotto);
        double benefit = gameResult.benefitResult(deposit);

        // then
        assertThat(benefit).isEqualTo(expected);
    }

    private static Stream<Arguments> GameResultProvider() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", "1,2,3,4,5,6", Rank.FIRST),
                Arguments.of("1,2,3,4,5,6", "1,2,3,4,5,7", Rank.SECOND),
                Arguments.of("1,2,3,4,5,6", "1,2,3,4,7,8", Rank.THIRD),
                Arguments.of("1,2,3,4,5,6", "1,2,3,7,8,9", Rank.FOURTH)
        );
    }
    private static Stream<Arguments> benefitResultProvider() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", "1,2,3,4,5,6", 1000, 2000000.00),
                Arguments.of("1,2,3,4,5,6", "1,2,3,4,5,7", 1000, 1500.00),
                Arguments.of("1,2,3,4,5,6", "1,2,3,4,7,8", 1000, 50.00),
                Arguments.of("1,2,3,4,5,6", "1,2,3,7,8,9", 1000, 5.00),
                Arguments.of("1,2,3,4,5,6", "1,2,7,8,9,10", 1000, 0.00)
        );
    }
}
