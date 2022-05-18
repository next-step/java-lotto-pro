package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomNumbersGeneratorTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 45})
    void 숫자사이즈_0_45_뽑기(int size) {
        assertThat(RandomNumbersGenerator.generate(size)).hasSize(size);
    }

    @Test
    void 숫자사이즈_마이너스() {
        assertThatThrownBy(() -> RandomNumbersGenerator.generate(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자사이즈_45초과() {
        assertThatThrownBy(() -> RandomNumbersGenerator.generate(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
