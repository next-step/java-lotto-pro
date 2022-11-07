package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static lotto.domain.Lotto.DUPLICATE_EXCEPTION_MESSAGE;
import static lotto.domain.Lotto.LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("당첨번호")
class WinningLottoTest {

    @DisplayName("6자리 미만일 수 없다.")
    @ParameterizedTest
    @MethodSource("lotto.fixture.WinningLottoFixture#size")
    void size(String[] numbers, String bonusBall) {
        assertThatThrownBy(() -> new WinningLotto(numbers, new BonusBall(bonusBall)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_SIZE + "개여야합니다.");
    }

    @DisplayName("중복된 수를 입력할 수 없다.")
    @ParameterizedTest
    @MethodSource("lotto.fixture.WinningLottoFixture#duplicate")
    void duplicateNumber(String[] numbers, String bonusBall) {
        assertThatThrownBy(() -> new WinningLotto(numbers, new BonusBall(bonusBall)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_EXCEPTION_MESSAGE);
    }

    @DisplayName("숫자만 입력 가능하다.")
    @ParameterizedTest
    @MethodSource("lotto.fixture.WinningLottoFixture#type")
    void type(String[] numbers, String bonusBall) {
        assertThatThrownBy(() -> new WinningLotto(numbers, new BonusBall(bonusBall)))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("생성")
    @ParameterizedTest
    @MethodSource("lotto.fixture.WinningLottoFixture#constructor")
    void constructor(String[] numbers, String bonusBall) {
        assertThatNoException().isThrownBy(() -> new WinningLotto(numbers, new BonusBall(bonusBall)));
    }

    @DisplayName("보너스 볼은 당첨번호와 중복할 수 없다.")
    @ParameterizedTest
    @MethodSource("lotto.fixture.WinningLottoFixture#duplicateBonusBall")
    void duplicateBonusBall(String[] numbers, String bonusBall) {
        assertThatThrownBy(() -> new WinningLotto(numbers, new BonusBall(bonusBall)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_EXCEPTION_MESSAGE);
    }
}
