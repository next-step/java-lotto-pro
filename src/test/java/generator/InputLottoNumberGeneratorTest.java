package generator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputLottoNumberGeneratorTest {
    private final List<Integer> lottoNumbers = Arrays.asList(2, 4, 5, 7);

    @DisplayName("입력받은 문자열을 콤마(,)로 구분하여 trim 한 값으로 Integer List 를 생성한다.")
    @Test
    void inputLottoNumberGenerator() {
        InputLottoNumberGenerator inputLottoNumberGenerator = new InputLottoNumberGenerator(" 2, 4 ,5 ,  7  ");
        List<Integer> LottoNumbers = inputLottoNumberGenerator.generate();
        assertAll(
                () -> assertThat(LottoNumbers).isEqualTo(lottoNumbers),
                () -> assertThat(LottoNumbers).hasSize(4)
        );
    }

    @DisplayName("숫자 변환에 유효하지 않은 문자열에 대해 IllegalArgumentException 테스트")
    @ParameterizedTest(name = "숫자 변환에 유효하지 않은 문자열{0}에 대해 IllegalArgumentException 테스트")
    @ValueSource(strings = {"1 ,p,0", "1. 1, 2", ",#", "3,,3"})
    void inputLottoNumberGeneratorInValid(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new InputLottoNumberGenerator(input))
                .withMessage("유효하지 않은 입력값입니다.");
    }
}
