package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoNumberGenerateStrategyTest {
    @Test
    @DisplayName("생성된_로또_개수_채크")
    void 생성된_로또_개수_채크() {
        assertThat(new RandomLottoNumberGenerateStrategy().generate()).hasSize(6);
    }
}
