package lotto_auto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoNumbersTest {
    @ParameterizedTest
    @ValueSource(strings = "1, 1, 3, 4, 5, 6, 7")
    public void 로또번호_개수_체크() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumbers("1, 2, 3, 4, 5, 6, 7"))
                .withMessage(LottoNumbers.NOT_MATCHED_NUMBER_SIZE);
    }

    @ParameterizedTest
    @ValueSource(strings = "1, 1, 3, 4, 5, 6")
    public void 로또번호_중복_체크() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumbers("1, 1, 3, 4, 5, 6"))
                .withMessage(LottoNumbers.EXIST_DUPLICATE_VALUE);
    }

    @ParameterizedTest
    @ValueSource(strings = "1, 1, 3, 4, 5, a")
    public void 로또번호_숫자_이외의_값_체크(String numbers) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->  new LottoNumbers(numbers))
                .withMessage(LottoNumbers.NOT_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(strings = "1, 9, 3, 4, 5, 10")
    public void 외부에서_로또_번호_추가_시_에러_발생(String numbers) {
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);

        Assertions.assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> lottoNumbers.getLottoNumberSet().add(new LottoNumber(7)));
    }
}
