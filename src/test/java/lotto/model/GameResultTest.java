package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameResultTest {

    private final LottoGame lottoGame = new LottoGame();

    @BeforeEach
    void before() {
        lottoGame.insertMoney("1000");
        lottoGame.purchaseManualLotto("1");
        lottoGame.inputManualLottoNumber("1,2,3,4,5,6");
    }

    @ParameterizedTest(name = "사용자의 로또 번호와 당첨 번호를 비교하여 {3}을 1개 가진다")
    @MethodSource("GameResultProvider")
    void calculateRankTest(WinningLotto winningLotto, Rank rank) {
        // given
        GameResult gameResult = new GameResult(lottoGame, winningLotto);

        // when
        Map<Rank, Integer> rankIntegerMap = gameResult.gameResult();
        long actual = rankIntegerMap.get(rank);

        // then
        assertThat(actual).isEqualTo(1L);
    }

    @ParameterizedTest(name = "게임 결과 객체는 수익률을 반환한다")
    @MethodSource("GameResultProvider")
    void benefitResultTest(WinningLotto winningLotto, Rank rank, double expected) {
        // given
        GameResult gameResult = new GameResult(lottoGame, winningLotto);

        // when
        double benefit = gameResult.calculateBenefit();

        // then
        assertThat(benefit).isEqualTo(expected);
    }

    @ParameterizedTest(name ="수익률의 이익/손해 기준은 1이다")
    @MethodSource("GameResultProvider")
    void referenceValueTest(WinningLotto winningLotto) {
        // given
        GameResult gameResult = new GameResult(lottoGame, winningLotto);

        // when
        double actual = gameResult.referenceValue();

        // then
        assertThat(actual).isEqualTo(1);
    }

    private static Stream<Arguments> GameResultProvider() {
        return Stream.of(
                Arguments.of(WinningLotto.of("1,2,3,4,5,6", "11"), Rank.FIRST, 2000000.00),
                Arguments.of(WinningLotto.of("1,2,3,4,5,11", "6"), Rank.SECOND, 30000.00),
                Arguments.of(WinningLotto.of( "1,2,3,4,5,7", "11"), Rank.THIRD, 1500.00),
                Arguments.of(WinningLotto.of("1,2,3,4,7,8", "11"), Rank.FOURTH, 50.00),
                Arguments.of(WinningLotto.of("1,2,3,7,8,9", "11"), Rank.FIFTH, 5.00)
        );
    }
}
