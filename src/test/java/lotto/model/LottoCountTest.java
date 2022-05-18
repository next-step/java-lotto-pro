package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoCountTest {

    private final LottoCount lottoCount = new LottoCount(10);

    @ParameterizedTest(name = "로또 구매 장수를 숫자가 아닌 값으로 입력하면 오류가 발생한다.")
    @ValueSource(strings = {"일", "%", "one"})
    void invalidCountInputTest(String countOfManualLotto) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                        () -> lottoCount.purchaseManualLottoTicket(countOfManualLotto))
                .withMessageContaining("유효하지 않은 값입니다.");
    }

    @ParameterizedTest(name = "로또 구매 장수를 음수로 입력하면 오류가 발생한다.")
    @ValueSource(strings = {"-1", "-5", "-10"})
    void invalidNegativeNumberInputTest(String countOfManualLotto) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                        () -> lottoCount.purchaseManualLottoTicket(countOfManualLotto))
                .withMessageContaining("구입 장수는 0이상의 정수 입니다.");
    }

    @ParameterizedTest(name = "로또 구매 장수가 최대 구매 장수를 초과하면 오류가 발생한다.")
    @ValueSource(strings = {"11", "100", "2000"})
    void overMaxLottoCountInputTest(String countOfManualLotto) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                        () -> lottoCount.purchaseManualLottoTicket(countOfManualLotto))
                .withMessageContaining("구입 가능한 최대 장수를 초과하였습니다.");
    }

    @ParameterizedTest(name = "로또를 수동으로 {0}장 구매시 자동 구매 장수는 {1}이다.")
    @CsvSource(value = {"10:0", "1:9", "0:10", "5:5"}, delimiter = ':')
    void getCountOfAutoLottoTest(String countOfManualLotto, int expected) {
        // given & when
        lottoCount.purchaseManualLottoTicket(countOfManualLotto);
        int actual = lottoCount.purchaseAutoLottoTicket();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
