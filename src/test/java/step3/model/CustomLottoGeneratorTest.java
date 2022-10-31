package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CustomLottoGeneratorTest {
    private LottoGenerator lottoGenerator;

    @Test
    @DisplayName("사용자가 수동으로 입력한 번호로 로또를 만든다.")
    void create_custom_generate_lotto_test() {
        List<Integer> customLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        lottoGenerator = new CustomLottoGenerator(customLottoNumbers);
        Lotto lotto = lottoGenerator.generateLotto();

        List<Number> customLottoNumbersByIntegerToNumber = customLottoNumbers.stream()
            .map(customLottoNumber -> new Number(customLottoNumber))
            .collect(Collectors.toList());

        assertThat(lotto.getNumbers()).isEqualTo(customLottoNumbersByIntegerToNumber);
    }
}
