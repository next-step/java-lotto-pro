package lotto.model;

import static lotto.constants.LottoConstant.NUMBER_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberGeneratorTest {

    @Test
    @DisplayName("로또 생성기를 통해 생성한 로또 확인")
    void autoLottoNumber() {
        LottoNumber lottoNumber = LottoNumberGenerator.auto();

        Assertions.assertAll(
                () -> assertThat(lottoNumber).isNotNull(),
                () -> assertThat(lottoNumber.getLottoNumber()).hasSize(NUMBER_SIZE)
        );
    }

    @ParameterizedTest(name = "잘못된 문자열({0}) 로또 번호를 입력받을 때 IllegalArgumentException가 발생")
    @ValueSource(strings = {"1,2,3,4,5", "5, 8, 10, 12, 16, 18, 20", "1, 2, 3, 4, 5, a"})
    void inputInvalidLottoNumberString(String invalidLottoNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumberGenerator.of(invalidLottoNumber))
                .withMessage("올바른 로또 번호 양식이 아닙니다.");
    }

    @Test
    @DisplayName("로또 번호를 벗어난 값을 입력받을 때 IllegalArgumentException가 발생")
    void inputOutOfRangeLottoNumberString() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumberGenerator.of("1, 2, 3, 4, 5, 100"))
                .withMessage("로또 숫자 범위를 벗어났습니다.");
    }

    @Test
    @DisplayName("로또 번호를 중복된 값을 입력받을 때 IllegalArgumentException가 발생")
    void inputDuplicateLottoNumberString() {
        assertAll(
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> LottoNumberGenerator.of("1, 2, 5, 4, 5, 10"))
                        .withMessage("로또 숫자의 중복은 허용되지 않습니다."),
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> LottoNumberGenerator.of(Arrays.asList(1, 2, 5, 4, 5, 10)))
                        .withMessage("로또 숫자의 중복은 허용되지 않습니다.")
        );
    }
}
