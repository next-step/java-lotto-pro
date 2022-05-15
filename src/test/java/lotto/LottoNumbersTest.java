package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @Test
    void 로또_번호_6개_발급() {
        LottoNumbers numbers = new LottoNumbers();
        assertThat(numbers.getNumbersAsArray().length).isEqualTo(6);
    }
}
