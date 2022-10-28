package lotto.generate;

import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @Test
    @DisplayName("로또 번호 6개를 자동으로 생성한다.")
    void lotto_number_generator() {
        assertThat(LottoNumberGenerator.generate().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호 6개를 자동으로 생성하며 반환 값은 List<LottoNumber> 형태이다.")
    void lotto_number_generator_return_Lotto_number_list() {
        assertThat(LottoNumberGenerator.generate().size()).isEqualTo(6);
        assertThat(LottoNumberGenerator.generate()).first().isInstanceOf(LottoNumber.class);
    }
}
