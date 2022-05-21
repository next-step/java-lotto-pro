package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void winningLotto() {
        winningLotto = WinningLotto.of("1,2,3,4,5,6", "7");
    }

    @ParameterizedTest(name = "당첨 번호 중 하나라도 보너스 번호와 중복되는 경우 오류를 반환한다")
    @CsvSource(value = {"1,2,3,4,5,6:1", "1,2,3,4,5,6:6"}, delimiter = ':')
    void winningLottoDuplicateTest(String winnersNumber, String bonusInput) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                        () -> WinningLotto.of(winnersNumber, bonusInput))
                .withMessageContaining("이미 존재하는 번호 입니다.");
    }

    @ParameterizedTest(name = "사용자의 로또 번호와 당첨 번호들을 비교하여 일치하는 번호가 있는 경우 참을 반환한다")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void lottoNumberContainsTest(Number userNumber) {
        // given & when
        boolean actual = winningLotto.contains(userNumber);

        // then
        assertThat(actual).isTrue();
    }

    @ParameterizedTest(name = "사용자의 로또 번호와 당첨 번호를 비교하여 일치하는 번호가 없는 경우 거짓을 반환한다")
    @ValueSource(strings = {"7", "45"})
    void lottoNumberNotContainsTest(Number userNumber) {
        // given & when
        boolean actual = winningLotto.contains(userNumber);

        // then
        assertThat(actual).isFalse();
    }

    @ParameterizedTest(name = "사용자의 로또 번호와 보너스 번호를 비교하여 일치하는 번호가 있는 경우 참을 반환한다")
    @ValueSource(strings = {"7,8,9,10,11,12", "1,3,5,7,9,11"})
    void bonusNumberContainsTest(String inputs) {
        // given
        Lotto userLotto = new Lotto(new InputNumberGenerator(inputs));

        // when
        boolean actual = winningLotto.containsBonusNumber(userLotto);

        // then
        assertThat(actual).isTrue();
    }

    @ParameterizedTest(name = "사용자의 로또 번호와 보너스 번호를 비교하여 일치하는 번호가 없는 경우 거짓을 반환한다")
    @ValueSource(strings = {"1,2,3,4,5,6", "30,35,40,45,5,10"})
    void bonusNumberNotContainsTest(String inputs) {
        // given
        Lotto userLotto = new Lotto(new InputNumberGenerator(inputs));

        // when
        boolean actual = winningLotto.containsBonusNumber(userLotto);

        // then
        assertThat(actual).isFalse();
    }
}
