package step3.model.machine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import step3.model.value.Rule;

class ShuffleLottoGeneratorTest {

    @Test
    void 생성번호_갯수_통제_되는지_확인() {
        LottoAutoGenerator lottoGenerator = new ShuffleLottoGenerator();
        assertThat(lottoGenerator.generateLottoAuto().size())
                .isEqualTo(Rule.AUTO_GENERATE_END_NUM-Rule.AUTO_GENERATE_START_NUM);
    }
}