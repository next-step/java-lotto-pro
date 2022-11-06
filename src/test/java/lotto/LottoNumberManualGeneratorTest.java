package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("로또 수동 생성기 테스트")
class LottoNumberManualGeneratorTest {

    @DisplayName("생성 성공")
    @Test
    void create_generator_success() {
        assertThatNoException().isThrownBy(
                () -> new LottoNumberManualGenerator("1,2,3,4,5,6"));
    }

    @Test
    void generate_numbers_success() {
        //given:
        String inputNumber = "1,2,3,4,5,6";
        LottoNumberManualGenerator manualGenerator = new LottoNumberManualGenerator(inputNumber);
        List<LottoNumber> expected = Arrays.asList(new LottoNumber("1"),
                new LottoNumber("2"),
                new LottoNumber("3"),
                new LottoNumber("4"),
                new LottoNumber("5"),
                new LottoNumber("6"));
        //when, then:
        assertThat(manualGenerator.generate()).usingRecursiveComparison().isEqualTo(expected);
    }
}
