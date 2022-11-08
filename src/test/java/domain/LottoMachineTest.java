package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    @ParameterizedTest
    @MethodSource("arrangeIssueLottos")
    void 금액에_따른_로또를_발급한다(SelfPickLottos selfPickNumbers, int money, int expectedAmount) {
        Lottos lottos = LottoMachine.issueLottos(selfPickNumbers, money);
        assertThat(lottos.size()).isEqualTo(expectedAmount);
    }

    static Stream<Arguments> arrangeIssueLottos() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        return Stream.of(
                Arguments.arguments(
                        new SelfPickLottos(Collections.emptyList()), 1000, 1,
                        new SelfPickLottos(Collections.singletonList(numbers)), 1000, 1,
                        new SelfPickLottos(Arrays.asList(numbers, numbers)), 10000, 10));
    }
}
