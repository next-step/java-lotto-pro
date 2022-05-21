package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameTest {

    private final LottoGame lottoGame = new LottoGame();

    @ParameterizedTest(name = "유효하지 않은 값인 {0}을 입력하면 오류를 반환한다")
    @ValueSource(strings = {"a", "-1000", "천원"})
    void insertInvalidMoneyTest(String money) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> lottoGame.insertMoney(money));
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

    @ParameterizedTest(name = "{0}원으로 수동 로또 {1}장을 구매한 결과 {2}장을 구매한다")
    @CsvSource(value = {"10000:0:0", "10000:10:10", "10000:5:5"}, delimiter = ':')
    void purchaseManualLottoTest(String money, String countOfManualLotto, int expected) {
        // given
        lottoGame.insertMoney(money);

        // when
        int actual = lottoGame.purchaseManualLotto(countOfManualLotto);

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

    @ParameterizedTest(name = "유효하지 않은 로또 번호를 입력하면 오류를 반환한다")
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,5", "일,이,삼,사,오,륙"})
    void invalidInputManualLottoTest(String inputs) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> lottoGame.inputManualLottoNumber(inputs));
    }

    @ParameterizedTest(name = "현재 생성된 로또의 갯수와 인자값을 비교하여 참/거짓을 반환한다")
    @CsvSource(value = {"1000:0:1", "10000:0:10"}, delimiter = ':')
    void isSameSizeOfUserLottoTest(String money, String countOfManualLotto, int totalCountOfLotto) {
        // given
        lottoGame.insertMoney(money);
        lottoGame.purchaseManualLotto(countOfManualLotto);
        lottoGame.purchaseAutoLotto(new RandomNumberGenerator());

        // when
        boolean actual = lottoGame.isSameSizeOfUserLotto(totalCountOfLotto);

        // then
        assertThat(actual).isTrue();
    }
}
