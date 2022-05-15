package lotto_auto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoNumbersTest {
    @Test
    public void 로또리스트_개수_체크() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumbers("1, 2, 3, 4, 5, 6, 7"))
                .withMessage(LottoNumbers.NOT_MATCHED_NUMBER_SIZE);
    }

    @Test
    public void 로또리스트_중복_체크() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumbers("1, 1, 3, 4, 5, 6"))
                .withMessage(LottoNumbers.EXIST_DUPLICATE_VALUE);
    }
}
