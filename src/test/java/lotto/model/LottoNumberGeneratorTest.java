package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constants.LottoConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @Test
    @DisplayName("로또 생성기를 통해 생성한 사이즈 확인")
    void verifyLottoNumberGenerator() {
        assertThat(LottoNumberGenerator.generate()).hasSize(LottoConstant.NUMBER_SIZE);
    }
}
