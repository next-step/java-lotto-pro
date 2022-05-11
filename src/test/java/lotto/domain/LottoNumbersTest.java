package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import generator.LottoNumberGenerator;
import generator.TestNumberGenerator;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @Test
    @DisplayName("LottoNumberGenerator 를 이용해 LottoNumbers 일급 컬랙션을 생성한다.")
    void generate01() {
        // given & when
        LottoNumbers lottoNumbers = LottoNumbers.generateBy(new LottoNumberGenerator());

        // then
        assertThat(lottoNumbers.getReadOnlyLottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("LottoNumbers 를 구성하는 LottoNumber는 고유한 숫자로 이뤄져야 한다.")
    void exception01() {
        // given & when & then
        assertThatThrownBy(() -> LottoNumbers.generateBy(new TestNumberGenerator(Arrays.asList(1, 1, 2, 2, 3, 3))))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]")
            .hasMessageContaining(String.valueOf(Arrays.asList(1, 1, 2, 2, 3, 3)));
    }
}