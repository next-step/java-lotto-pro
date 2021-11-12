package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberTest {

    @DisplayName("[정상]로또번호 생성 범위 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:45"}, delimiter = ':')
    void 로또번호_생성_범위_정상(int inNumber) {
        // given
        LottoNumber lottoNumber = new LottoNumber(inNumber);
        // when
        // then
        assertThat(lottoNumber).isEqualTo(new LottoNumber(inNumber));
    }

    @DisplayName("[ERROR]로또번호 생성 범위 테스트")
    @ParameterizedTest
    @CsvSource(value = {"-1:0:100"}, delimiter = ':')
    void 로또번호_생성_범위_예외(String inNumber) {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(inNumber));
    }
}
