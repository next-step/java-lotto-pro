package lotto.model;

import static lotto.constants.LottoConstant.NUMBER_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberGeneratorTest {

    @Test
    @DisplayName("로또 자동 생성을 통한 리스트 사이즈 검증")
    void autoLottoNumber() {
        List<Number> result = LottoNumberGenerator.auto();
        assertAll(
                () -> assertThat(result).isNotNull(),
                () -> assertThat(result).hasSize(NUMBER_SIZE)
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
}
