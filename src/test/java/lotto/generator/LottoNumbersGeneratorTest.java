package lotto.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.constants.LottoConstant.LOTTO_PICK_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersGeneratorTest {

    @ParameterizedTest
    @DisplayName("로또 번호 생성을 확인한다.")
    @ValueSource(strings = {"10,4,1,23,20,45", "13,4,1,33,23,15"})
    void drawNumbers_번호생성(String input) {
        LottoNumbersGenerator lottoNumbersGenerator = new TestLottoNumbersGenerator(input);

        assertThat(lottoNumbersGenerator.drawNumbers())
                .isNotEmpty()
                .hasSize(LOTTO_PICK_COUNT);
    }

    @ParameterizedTest
    @DisplayName("입력 값에 중복 번호가 존재하면 예외를 발생시킨다.")
    @ValueSource(strings = {"10,4,1,23,23,45", "13,4,1,23,33,23"})
    void drawNumbers_중복예외(String input) {
        assertThatThrownBy(() -> new TestLottoNumbersGenerator(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호에 중복 값이 존재합니다!");
    }

    @ParameterizedTest
    @DisplayName("입력 값이 사이즈를 초과하면 예외를 발생시킨다.")
    @ValueSource(strings = {"10,4,1,23,20,45,1", "13,4,1,23,33,23,113"})
    void drawNumbers_사이즈예외(String input) {
        assertThatThrownBy(() -> new TestLottoNumbersGenerator(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 %d개 입력해 주세요!", LOTTO_PICK_COUNT);
    }

}
