package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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

    @MethodSource(value = "calculateProfitTestParameter")
    @ParameterizedTest(name = "{0}원을 주고 로또를 구매하고, 5000원 1개가 당첨된다고 했을때, 수익률을 구한다.")
    void calculateProfit(int cost, List<Result> results, double expectedProfit) {
        double profit = lottoMachine.calculateProfit(cost, results);
        assertEquals(expectedProfit, profit);
    }

    static Stream<Arguments> calculateProfitTestParameter() {
        List<Result> results = Arrays.asList(Result.FOURTH, Result.LOSE, Result.LOSE, Result.LOSE, Result.LOSE);
        return Stream.of(
            arguments(5000, results, 1.00),
            arguments(10000, results, 0.50),
            arguments(1000, results, 5.00)
        );
    }
}