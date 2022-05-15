package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberGeneratorTest {

    private static final int SIZE = 6;

    @DisplayName("1부터 45사이의 로또 번호 6개가 랜덤으로 생성된다")
    @Test
    void randomNumberGeneratorTest() {
        // given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        List<Number> randomLottoList = randomNumberGenerator.pickNumbers();

        // then
        assertThat(randomLottoList).hasSize(6);
    }

    @ParameterizedTest(name = "1부터 45사이의 로또 번호 6개가 수동으로 생성된다")
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 11, 15, 20, 25, 45"})
    void inputNumberGeneratorTest(String input) {
        // given
        InputNumberGenerator inputNumberGenerator = new InputNumberGenerator(input);

        // when
        List<Number> inputLottoList = inputNumberGenerator.pickNumbers();

        // then
        assertThat(inputLottoList).hasSize(6);
    }

    @ParameterizedTest(name = "숫자가 아닌 값을 입력하면 오류가 발생한다")
    @ValueSource(strings = {"1,2,3,4,$,6", "1, 이, 15, 20, 25, 45"})
    void invalidInputNumberGeneratorTest(String input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new InputNumberGenerator(input))
                .withMessageContaining("유효하지 않은 값입니다.");
    }

    @ParameterizedTest(name = "잘못된 범위를 입력하면 오류가 발생한다")
    @ValueSource(strings = {"1,2,3,4,5,66", "1, 11, -15, 20, 25, 45"})
    void invalidRangeInputNumberGeneratorTest(String input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new InputNumberGenerator(input))
                .withMessageContaining("유효하지 않은 범위의 숫자입니다.");
    }

    @ParameterizedTest(name = "중복을 제외한 숫자의 갯수가 6개가 아니면 오류가 발생한다")
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1, 11, 15, 20, 25"})
    void invalidSizeInputNumberGeneratorTest(String input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new InputNumberGenerator(input))
                .withMessageContaining("당첨 번호는 중복이 없는 " + SIZE + "개의 숫자입니다.");
    }
}
