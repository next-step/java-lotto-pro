package lotto.domain;

import lotto.fixture.LottoFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.Lotto.DUPLICATE_EXCEPTION_MESSAGE;
import static lotto.domain.Lotto.LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("당첨번호")
class WinningLottoTest {

    @DisplayName("6자리 미만일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {2})
    void size(int bonusBall) {
        assertThatThrownBy(() -> new WinningLotto(LottoFixture.size(), new Number(bonusBall)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_SIZE + "개여야합니다.");
    }

    @DisplayName("중복된 수를 입력할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {2})
    void duplicateNumber(int bonusBall) {
        assertThatThrownBy(() -> new WinningLotto(LottoFixture.duplicate(), new Number(bonusBall)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_EXCEPTION_MESSAGE);
    }

    @DisplayName("숫자만 입력 가능하다.")
    @ParameterizedTest
    @ValueSource(ints = {7})
    void type(int bonusBall) {
        assertThatThrownBy(() -> new WinningLotto(LottoFixture.type(), new Number(bonusBall)))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("생성")
    @ParameterizedTest
    @ValueSource(ints = {7})
    void constructor(int bonusBall) {
        assertThatNoException().isThrownBy(() -> new WinningLotto(LottoFixture.constructor(), new Number(bonusBall)));
    }

    @DisplayName("보너스 볼은 당첨번호와 중복할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {5})
    void duplicateBonusBall(int bonusBall) {
        assertThatThrownBy(() -> new WinningLotto(LottoFixture.constructor(), new Number(bonusBall)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_EXCEPTION_MESSAGE);
    }
}
