package study.step3.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.Lotto;

class LottoGeneratorTest {
    @Test
    @DisplayName("여러개의 로또 생성")
    void generate() {
        final int genSize = 5;
        List<Lotto> lottos = LottoGenerator.generate(genSize);
        assertThat(lottos.size()).isEqualTo(genSize);
    }

    @Test
    @DisplayName("여러개의 로또 생성 - 잘못된 숫자 - 0")
    void generate_exception_zero() {
        assertThatThrownBy(() -> LottoGenerator.generate(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("여러개의 로또 생성 - 잘못된 숫자 - -1")
    void generate_exception_negative() {
        assertThatThrownBy(() -> LottoGenerator.generate(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
