package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 6})
    void 입력받은_수량만큼_로또발급(int quantity) {
        Lottos lottos = new Lottos(quantity);

        assertThat(lottos.getLottos()).hasSize(quantity);
    }

}