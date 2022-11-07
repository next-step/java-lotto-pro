package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SelfPickLottosTest {
    @ParameterizedTest
    @MethodSource("arrangeSelfPickNumbersAndSize")
    void 수동로또_수량_반환(List<Set<Integer>> selfPickNumbers, int size) {
        SelfPickLottos selfPickLottos = new SelfPickLottos(selfPickNumbers);
        assertThat(selfPickLottos.size()).isEqualTo(size);
    }

    @ParameterizedTest
    @MethodSource("arrangeSelfPickNumbersAndPrice")
    void 수동로또_가격_반환(List<Set<Integer>> selfPickNumbers, int price) {
        SelfPickLottos selfPickLottos = new SelfPickLottos(selfPickNumbers);
        assertThat(selfPickLottos.price()).isEqualTo(price);
    }

    static Stream<Arguments> arrangeSelfPickNumbersAndSize() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        return Stream.of(
            Arguments.arguments(
                Collections.emptyList(), 0,
                Collections.singletonList(numbers), 1,
                Arrays.asList(numbers, numbers), 2));
    }

    static Stream<Arguments> arrangeSelfPickNumbersAndPrice() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        return Stream.of(
            Arguments.arguments(
                Collections.emptyList(), 0,
                Collections.singletonList(numbers), 6000,
                Arrays.asList(numbers, numbers), 12000));
    }
}
