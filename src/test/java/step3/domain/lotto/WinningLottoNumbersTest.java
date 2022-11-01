package step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step3.type.ErrorMessageType.*;

class WinningLottoNumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, @", "q, 2, 3, 4, 5, 6"})
    @DisplayName("당첨 번호는 숫자만 입력 가능합니다.")
    void lottoNumberCannotBeLessThanStartInclusive(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumbers(input))
                .withMessageContaining(INPUT_ONLY_ALLOW_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7"})
    @DisplayName("당첨 번호는 6자리만 입력 가능합니다.")
    void lottoNumberLengthDefaultSix(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumbers(input))
                .withMessageContaining(LOTTO_NUMBER_WRONG_SIZE.getMessage());
    }

    @Test
    @DisplayName("당첨 번호는 중복번호 입력이 불가능합니다.")
    void lottoNumberNotAllowDuplicate() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumbers("1, 2, 3, 4, 5, 5"))
                .withMessageContaining(LOTTO_NUMBER_DUPLICATE.getMessage());
    }
}
