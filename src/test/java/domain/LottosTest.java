package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static domain.strategy.RandomNumberGenerateStrategy.DEFAULT;
import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @ParameterizedTest
    @MethodSource("arrangeLottosAndSize")
    void 로또_수량_반환(SelfPickLottos selfPickLottos, QuickPickLottos quickPickLottos, int size) {
        Lottos lottos = new Lottos(selfPickLottos, quickPickLottos);
        assertThat(lottos.size()).isEqualTo(size);
    }

    @ParameterizedTest
    @MethodSource("arrangeIssueLottos")
    void 금액에_따른_로또_발급(SelfPickLottos selfPickNumbers, int money, int expectedAmount) {
        Lottos lottos = Lottos.createLottos(selfPickNumbers, money);
        assertThat(lottos).isNotNull();
        assertThat(lottos.size()).isEqualTo(expectedAmount);
    }

    @ParameterizedTest
    @MethodSource("arrangeSpentMoney")
    void 금액에_따른_로또_발급(SelfPickLottos selfPickNumbers, QuickPickLottos quickPickLottos, int expectedSpentMoney) {
        Lottos lottos = new Lottos(selfPickNumbers, quickPickLottos);
        assertThat(lottos.spentMoney()).isEqualTo(expectedSpentMoney);
    }

    static Stream<Arguments> arrangeLottosAndSize() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        return Stream.of(
                Arguments.arguments(
                        new SelfPickLottos(Collections.emptyList()), QuickPickLottos.of(0, DEFAULT), 0,
                        new SelfPickLottos(Collections.emptyList()), QuickPickLottos.of(1000, DEFAULT), 1,
                        new SelfPickLottos(Collections.singletonList(numbers)), QuickPickLottos.of(1000, DEFAULT), 2));
    }

    static Stream<Arguments> arrangeIssueLottos() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        return Stream.of(
                Arguments.arguments(
                        new SelfPickLottos(Collections.emptyList()), 1000, 1,
                        new SelfPickLottos(Collections.singletonList(numbers)), 1000, 1,
                        new SelfPickLottos(Arrays.asList(numbers, numbers)), 10000, 10));
    }

    static Stream<Arguments> arrangeSpentMoney() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        return Stream.of(
                Arguments.arguments(
                        new SelfPickLottos(Collections.emptyList()), QuickPickLottos.of(0, DEFAULT), 0,
                        new SelfPickLottos(Collections.emptyList()), QuickPickLottos.of(1000, DEFAULT), 1000,
                        new SelfPickLottos(Collections.singletonList(numbers)), QuickPickLottos.of(1000, DEFAULT), 2000));
    }
}
