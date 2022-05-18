package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameTest {

    private final LottoGame lottoGame = new LottoGame();

    @ParameterizedTest(name = "유효한 금액 {0}원을 입력하면 참을 반환한다")
    @ValueSource(strings = {"1000", "5000", "10000"})
    void insertMoneyTest(String money) {
        // given & when
        boolean actual = lottoGame.insertMoney(money);

        // then
        assertThat(actual).isTrue();
    }

    @ParameterizedTest(name = "유효하지 않은 값인 {0}을 입력하면 거짓을 반환한다")
    @ValueSource(strings = {"a", "-1000", "천원"})
    void insertInvalidMoneyTest(String money) {
        // given & when
        boolean actual = lottoGame.insertMoney(money);

        // then
        assertThat(actual).isFalse();
    }

    @ParameterizedTest(name = "로또 티켓을 {1}장 구매한다")
    @CsvSource(value = {"1000:1", "1100:1", "10000:10"}, delimiter = ':')
    void buyLottoTicketTest(String amount, int expected) {
        // given & when
        lottoGame.insertMoney(amount);
        int actual = lottoGame.buyLottoTicket(new RandomNumberGenerator());

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "유효한 당첨 번호를 입력하면 참을 반환한다")
    @ValueSource(strings = {"1,2,3,4,5,6", "10, 15, 20, 25, 30, 35"})
    void winnersNumberTest(String input) {
        // given & when
        boolean actual = lottoGame.winnersNumber(input);

        // then
        assertThat(actual).isTrue();
    }

    @ParameterizedTest(name = "유효하지 않은 당첨 번호를 입력하면 거짓을 반환한다")
    @ValueSource(strings = {"1,2,3,4,5", "10, 15, 20, 25, 30, 35, 40", "1,2,3,5,6,110", "-1,10,11,12,13,14",
            "일,이,삼,사,오,륙"})
    void invalidWinnersNumberTest(String input) {
        // given & when
        boolean actual = lottoGame.winnersNumber(input);

        // then
        assertThat(actual).isFalse();
    }

    @ParameterizedTest(name = "유효한 보너스 번호를 입력하면 참을 반환한다")
    @CsvSource(value = {"1,2,3,4,5,6:7", "10, 15, 20, 25, 30, 35:9"}, delimiter = ':')
    void bonusNumberTest(String input, String bonusNumber) {
        // given & when
        lottoGame.winnersNumber(input);
        boolean actual = lottoGame.bonusNumber(bonusNumber);

        // then
        assertThat(actual).isTrue();
    }

    @ParameterizedTest(name = "이미 당첨번호에 존재하는 번호를 보너스 번호로 입력하면 거짓을 반환한다")
    @CsvSource(value = {"1,2,3,4,5,6:1", "1,2,3,4,5,6:2", "1,2,3,4,5,6:3", "1,2,3,4,5,6:4", "1,2,3,4,5,6:5",
            "1,2,3,4,5,6:6"}, delimiter = ':')
    void dupBonusNumberTest(String input, String bonusNumber) {
        // given & when
        lottoGame.winnersNumber(input);
        boolean actual = lottoGame.bonusNumber(bonusNumber);

        // then
        assertThat(actual).isFalse();
    }

    @ParameterizedTest(name = "유효하지 않은 보너스 번호를 입력하면 거짓을 반환한다")
    @CsvSource(value = {"10, 15, 20, 25, 30, 35:-1", "1,2,3,4,5,6:46", "1,2,3,4,5,6:칠",
            "1,2,3,4,5,6:&"}, delimiter = ':')
    void invalidBonusNumberTest(String input, String bonusNumber) {
        // given & when
        lottoGame.winnersNumber(input);
        boolean actual = lottoGame.bonusNumber(bonusNumber);

        // then
        assertThat(actual).isFalse();
    }

    @Test
    @DisplayName("수익률의 이익/손해 기준은 1이다")
    void referenceValueTest() {
        // given & when & then
        assertThat(lottoGame.referenceValue()).isEqualTo(1);
    }

    @ParameterizedTest(name = "게임의 결과 미당첨을 제외한 각 등수가 몇개인지를 반환한다")
    @MethodSource("gameResultProvider")
    void gameResultTest(String userInputs, String winnerInputs, String bonusNumber, HashMap<Rank, Integer> expected) {
        // given
        lottoGame.insertMoney("1000");
        lottoGame.buyLottoTicket(new InputNumberGenerator(userInputs));
        lottoGame.winnersNumber(winnerInputs);
        lottoGame.bonusNumber(bonusNumber);

        // when
        Map<Rank, Integer> actual = lottoGame.gameResult();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    // benefitResult
    @ParameterizedTest(name = "게임의 결과 수익률을 반환한다")
    @MethodSource("gameResultProvider")
    void benefitResultTest(String userInputs, String winnerInputs, String bonusNumber,
                           HashMap<Rank, Integer> expectedGameResult,
                           double expected) {
        // given
        lottoGame.insertMoney("1000");
        lottoGame.buyLottoTicket(new InputNumberGenerator(userInputs));
        lottoGame.winnersNumber(winnerInputs);
        lottoGame.bonusNumber(bonusNumber);
        Map<Rank, Integer> gameResult = lottoGame.gameResult();

        // when
        double actual = lottoGame.benefitResult();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "사용자가 {0}원을 입력하면 {1}개의 로또가 생성된다")
    @MethodSource("userLotteryProvider")
    void getUserLotteryTest(String money, int expected) {
        // given
        lottoGame.insertMoney(money);
        lottoGame.buyLottoTicket(new RandomNumberGenerator());

        // when
        List<Lotto> actual = lottoGame.getUserLotto();

        // then
        assertThat(actual).hasSize(expected);
    }

    private static Stream<Arguments> gameResultProvider() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", "1,2,3,4,5,6", "7", new HashMap<Rank, Integer>() {
                    {
                        put(Rank.FIFTH, 0);
                        put(Rank.FOURTH, 0);
                        put(Rank.THIRD, 0);
                        put(Rank.SECOND, 0);
                        put(Rank.FIRST, 1);
                    }
                }, 2000000.00),
                Arguments.of("1,2,3,4,5,7", "1,2,3,4,5,6", "7", new HashMap<Rank, Integer>() {
                    {
                        put(Rank.FIFTH, 0);
                        put(Rank.FOURTH, 0);
                        put(Rank.THIRD, 0);
                        put(Rank.SECOND, 1);
                        put(Rank.FIRST, 0);
                    }
                }, 30000.00),
                Arguments.of("1,2,3,4,5,8", "1,2,3,4,5,6", "7", new HashMap<Rank, Integer>() {
                    {
                        put(Rank.FIFTH, 0);
                        put(Rank.FOURTH, 0);
                        put(Rank.THIRD, 1);
                        put(Rank.SECOND, 0);
                        put(Rank.FIRST, 0);
                    }
                }, 1500.00),
                Arguments.of("1,2,3,4,8,9", "1,2,3,4,5,6", "7", new HashMap<Rank, Integer>() {
                    {
                        put(Rank.FIFTH, 0);
                        put(Rank.FOURTH, 1);
                        put(Rank.THIRD, 0);
                        put(Rank.SECOND, 0);
                        put(Rank.FIRST, 0);
                    }
                }, 50.00),
                Arguments.of("1,2,3,8,9,10", "1,2,3,4,5,6", "7", new HashMap<Rank, Integer>() {
                    {
                        put(Rank.FIFTH, 1);
                        put(Rank.FOURTH, 0);
                        put(Rank.THIRD, 0);
                        put(Rank.SECOND, 0);
                        put(Rank.FIRST, 0);
                    }
                }, 5.00),
                Arguments.of("1,2,8,9,10,11", "1,2,3,4,5,6", "7", new HashMap<Rank, Integer>() {
                    {
                        put(Rank.FIFTH, 0);
                        put(Rank.FOURTH, 0);
                        put(Rank.THIRD, 0);
                        put(Rank.SECOND, 0);
                        put(Rank.FIRST, 0);
                    }
                }, 0.00),
                Arguments.of("1,10,11,12,13,14", "1,2,3,4,5,6", "7", new HashMap<Rank, Integer>() {
                    {
                        put(Rank.FIFTH, 0);
                        put(Rank.FOURTH, 0);
                        put(Rank.THIRD, 0);
                        put(Rank.SECOND, 0);
                        put(Rank.FIRST, 0);
                    }
                }, 0.00),
                Arguments.of("8,9,10,11,12,13", "1,2,3,4,5,6", "7", new HashMap<Rank, Integer>() {
                    {
                        put(Rank.FIFTH, 0);
                        put(Rank.FOURTH, 0);
                        put(Rank.THIRD, 0);
                        put(Rank.SECOND, 0);
                        put(Rank.FIRST, 0);
                    }
                }, 0.00)
        );
    }

    private static Stream<Arguments> userLotteryProvider() {
        return Stream.of(Arguments.of("10000", 10),
                Arguments.of("50000", 50),
                Arguments.of("3000", 3),
                Arguments.of("1010", 1));
    }
}
