package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoNumbers는 ")
public class LottoNumbersTest {
    @DisplayName("6개의 LottoNumber로 구성된다.")
    @Test
    void validLottoNumber() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        LottoNumbers lottoNumbers = new LottoNumbers(numbers);

        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(numbers));
    }
}
