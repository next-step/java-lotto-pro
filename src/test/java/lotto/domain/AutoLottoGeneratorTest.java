package lotto.domain;

import lotto.controller.LottoCount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoGeneratorTest {

    @Test
    void 로또_카운트를_인자로_받아_로또를_생성한다() {
        // given
        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator(new LottoCount(5));
        // when
        Lottos result = autoLottoGenerator.generate();
        // then
        assertThat(result.count()).isEqualTo(5);
    }

}