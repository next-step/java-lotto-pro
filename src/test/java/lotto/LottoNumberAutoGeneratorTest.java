package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoNumberAutoGeneratorTest {
    @Test
    void 로또_번호_생성_개수_확인() {
        LottoNumberAutoGenerator lottoNumberAutoGenerator = new LottoNumberAutoGenerator();
        assertThat(lottoNumberAutoGenerator.generateSixNumbers().size()).isEqualTo(6);
    }
}
