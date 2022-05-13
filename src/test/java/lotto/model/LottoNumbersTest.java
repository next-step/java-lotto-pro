package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호를 입력받아 생성된 객체가 올바른지 검증")
    void verifyLottoNumbers() {
        LottoNumber lottoNumberOf1st = LottoNumberGenerator.of("1, 2, 3, 4, 5, 6");
        LottoNumber lottoNumberOf2nd = LottoNumberGenerator.of("1, 5, 7, 9, 11, 15");
        LottoNumbers lottoNumbers = new LottoNumbers(
                Arrays.asList(lottoNumberOf1st, lottoNumberOf2nd)
        );

        assertAll(
                () -> assertThat(lottoNumbers).isNotNull(),
                () -> assertThat(lottoNumbers.getLottoNumbers()).hasSize(2),
                () -> assertThat(lottoNumbers.getLottoNumbers()).containsExactly(lottoNumberOf1st, lottoNumberOf2nd)
        );
    }
}
