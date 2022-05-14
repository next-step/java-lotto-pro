package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호를 입력받아 생성된 객체가 올바른지 검증")
    void verifyLottoNumbers() {
        LottoNumber lottoNumberOf1st = new LottoNumber(
                Arrays.asList(
                        Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(6)
                )
        );
        LottoNumber lottoNumberOf2nd = new LottoNumber(
                Arrays.asList(
                        Number.of(1), Number.of(5), Number.of(7), Number.of(8), Number.of(11), Number.of(15)
                )
        );
        LottoNumbers lottoNumbers = new LottoNumbers(
                Arrays.asList(lottoNumberOf1st, lottoNumberOf2nd)
        );

        assertAll(
                () -> assertThat(lottoNumbers).isNotNull(),
                () -> assertEquals(2, lottoNumbers.getQuantity()),
                () -> assertThat(lottoNumbers.getLottoNumbers()).containsExactly(lottoNumberOf1st, lottoNumberOf2nd)
        );
    }
}
