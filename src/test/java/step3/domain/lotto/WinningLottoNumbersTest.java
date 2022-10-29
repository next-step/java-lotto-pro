package step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step3.type.ErrorMessageType.INPUT_ONLY_ALLOW_NUMBER;

class WinningLottoNumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, @", "q, 2, 3, 4, 5, 6"})
    @DisplayName("당첨 번호는 숫자만 입력 가능합니다.")
    void lottoNumberCannotBeLessThanStartInclusive(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumbers(input))
                .withMessageContaining(INPUT_ONLY_ALLOW_NUMBER.getMessage());
    }




}
