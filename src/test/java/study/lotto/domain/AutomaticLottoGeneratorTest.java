package study.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.lottomachine.LottoGenerator;

class AutomaticLottoGeneratorTest {
    private final LottoGenerator lottoGenerator = new AutomaticLottoGenerator();

    @Test
    @DisplayName("로또 번호를 자동 생성한다.")
    void 로또번호를_자동으로_생성() {
        assertThat(lottoGenerator.generate()).isNotNull();
    }
}
