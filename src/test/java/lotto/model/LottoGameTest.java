package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

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

    @ParameterizedTest(name = "로또 티켓을 자동 {1}장 구매한다")
    @CsvSource(value = {"1000:1", "1100:1", "10000:10"}, delimiter = ':')
    void buyLottoTicketTest(String amount, int expected) {
        // given & when
        lottoGame.insertMoney(amount);
        lottoGame.purchaseManualLotto("0");
        int actual = lottoGame.purchaseAutoLotto(new RandomNumberGenerator());

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

    @ParameterizedTest(name = "게임의 결과 미당첨을 제외한 5개의 등수 정보를 반환한다")
    @MethodSource("gameResultProvider")
    void gameResultTest(String userInputs, String winnerInputs, String bonusNumber) {
        // given
        lottoGame.insertMoney("1000");
        lottoGame.purchaseManualLotto("1");
        lottoGame.inputManualLottoNumber(userInputs);
        lottoGame.winnersNumber(winnerInputs);
        lottoGame.bonusNumber(bonusNumber);

        // when
        Map<Rank, Integer> actual = lottoGame.gameResult();

        // then
        assertThat(actual).hasSize(5);
    }

    @ParameterizedTest(name = "게임의 결과 수익률을 반환한다")
    @MethodSource("gameResultProvider")
    void benefitResultTest(String userInputs, String winnerInputs, String bonusNumber, double expected) {
        // given
        lottoGame.insertMoney("1000");
        lottoGame.purchaseManualLotto("1");
        lottoGame.inputManualLottoNumber(userInputs);
        lottoGame.winnersNumber(winnerInputs);
        lottoGame.bonusNumber(bonusNumber);
        lottoGame.gameResult();

        // when
        double actual = lottoGame.benefitResult();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "사용자가 {0}원을 입력하면 {1}개의 로또가 생성된다")
    @CsvSource(value = {"50000:50", "10000:10", "1500:1", "1000:1"}, delimiter = ':')
    void getUserLotteryTest(String money, int expected) {
        // given
        lottoGame.insertMoney(money);
        lottoGame.purchaseManualLotto("0");
        lottoGame.purchaseAutoLotto(new RandomNumberGenerator());

        // when
        List<Lotto> actual = lottoGame.getUserLotto();

        // then
        assertThat(actual).hasSize(expected);
    }

    @ParameterizedTest(name = "{0}원으로 수동 로또 {1}장을 구매가능한지 여부를 반환한다")
    @CsvSource(value = {"10000:0:true", "10000:10:true", "1000:10:false", "1000:2:false"}, delimiter = ':')
    void purchaseManualLottoTest(String money, String countOfManualLotto, boolean expected) {
        // given
        lottoGame.insertMoney(money);

        // when
        boolean actual = lottoGame.purchaseManualLotto(countOfManualLotto);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "유효한 번호를 입력받으면 유저의 로또 객체가 생성된다")
    @ValueSource(strings = {"1,2,3,4,5,6", "10, 15, 20, 25, 30, 35"})
    void inputManualLottoTest(String inputs) {
        // given
        String countOfManualLotto = "1";
        lottoGame.insertMoney("1000");

        // when
        lottoGame.purchaseManualLotto(countOfManualLotto);
        lottoGame.inputManualLottoNumber(inputs);
        List<Lotto> actual = lottoGame.getUserLotto();

        // then
        assertThat(actual).isNotEmpty();
    }

    @ParameterizedTest(name = "유효하지 않은 로또 번호를 입력하면 로또 객체가 생성되지 않는다")
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,5", "일,이,삼,사,오,륙"})
    void invalidInputManualLottoTest(String inputs) {
        // given
        String countOfManualLotto = "1";
        lottoGame.insertMoney("1000");

        // when
        lottoGame.purchaseManualLotto(countOfManualLotto);
        lottoGame.inputManualLottoNumber(inputs);
        List<Lotto> actual = lottoGame.getUserLotto();

        // then
        assertThat(actual).isEmpty();
    }

    private static Stream<Arguments> gameResultProvider() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", "1,2,3,4,5,6", "7", 2000000.00),
                Arguments.of("1,2,3,4,5,7", "1,2,3,4,5,6", "7", 30000.00),
                Arguments.of("1,2,3,4,5,8", "1,2,3,4,5,6", "7", 1500.00),
                Arguments.of("1,2,3,4,8,9", "1,2,3,4,5,6", "7", 50.00),
                Arguments.of("1,2,3,8,9,10", "1,2,3,4,5,6", "7", 5.00),
                Arguments.of("1,2,8,9,10,11", "1,2,3,4,5,6", "7", 0.00),
                Arguments.of("1,10,11,12,13,14", "1,2,3,4,5,6", "7", 0.00),
                Arguments.of("8,9,10,11,12,13", "1,2,3,4,5,6", "7", 0.00)
        );
    }
}
