package lotto;

import lotto.domain.LottoNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    @Test
    void 랜덤_숫자_6개를_발급한다() {
        // given
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        // when
        List<Integer> generated = lottoNumberGenerator.generate();
        // then
        assertThat(generated).hasSize(6);
    }
}