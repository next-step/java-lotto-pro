package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.generator.InputLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {
    final Lotto lotto = Lotto.draw(new InputLottoNumberGenerator("1, 2, 3, 4, 5, 6"));

    @DisplayName("로또 번호와 중복된 로또 번호인지 체크")
    @ParameterizedTest(name = "로또 번호와 중복된 로또 번호 {0}가 입력되면 IllegalArgumentException 예외")
    @ValueSource(strings = {"1", "3", "6"})
    void validateNewLottoNumber(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.of(lotto, LottoNumber.valueOf(input)))
                .withMessage("중복되는 로또 번호 입니다.");
    }
}
