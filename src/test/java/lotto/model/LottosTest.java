package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 5, 14, 50})
    void generateAuto(int size) {
        Lottos lottos = Lottos.generateAuto(size);
        assertThat(lottos).isNotNull();
        assertThat(lottos.size()).isEqualTo(size);
    }
}
