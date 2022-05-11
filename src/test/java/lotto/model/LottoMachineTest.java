package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoMachineTest {

    private LottoMachine lottoMachine = new LottoMachine();

    @MethodSource(value = "buyTestParameters")
    @ParameterizedTest(name = "1000원짜리 로또 구매가능한 수량을 구한다. {0}")
    void buy(int cost, int expectedQuantity) {
        Lottos lottos = lottoMachine.buy(cost);
        assertEquals(expectedQuantity, lottos.getQuantity());
    }

    static Stream<Arguments> buyTestParameters() {
        return Stream.of(
            arguments(0, 0),
            arguments(1000, 1),
            arguments(1001, 1)
        );
    }
}