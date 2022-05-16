package lotto;

import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    void 랜덤_숫자_6개를_발급한다() {
        // given
        LottoGenerator lottoGenerator = new LottoGenerator();
        // when
        List<Integer> generated = lottoGenerator.generate();
        // then
        assertThat(generated).hasSize(6);
    }
}