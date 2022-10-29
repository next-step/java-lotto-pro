package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {
    @Test
    void 생성된_숫자_개수_확인() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        assertThat(lottoNumberGenerator.generateSixNumbers().size()).isEqualTo(6);
    }
}
