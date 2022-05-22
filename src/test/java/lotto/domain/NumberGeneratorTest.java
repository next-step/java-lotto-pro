package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    @Test
    void 여섯자리_정수_여부() {
        NumberGenerator generator = new LottoNumberGenerator();
        assertThat(generator.generate()).hasSize(6);
    }

    @Test
    void 콤마로_구분된_번호_처리() {
        NumberGenerator generator = new LottoNumberGenerator();
        assertThat(generator.generate("1,2,3,4,5,6")).hasSize(6);
    }
}
