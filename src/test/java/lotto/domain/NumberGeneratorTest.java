package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @Test
    void 여섯자리_정수_여부() {
        NumberGenerator generator = new LottoNumberGenerator();
        assertThat(generator.generate()).hasSize(6);
    }

}
