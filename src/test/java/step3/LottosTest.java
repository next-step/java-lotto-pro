package step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Lottos;

class LottosTest {

    private Lottos lottos = new Lottos();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void generateLottos(int input) {
        Assertions.assertEquals(input, lottos.generateLottos(input).size());
    }

}