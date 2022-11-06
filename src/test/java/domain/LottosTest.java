package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @ParameterizedTest
    @MethodSource("arrangeLottosAndSize")
    void 로또_수량_반환(Lottos lottos, int size) {
        assertThat(lottos.size()).isEqualTo(size);
    }

    @ParameterizedTest
    @CsvSource(value = {"10000|10", "14000|14"}, delimiter = '|')
    void 금액에_따른_로또_발급(int price, int expectedAmount) {
        Lottos lottos = Lottos.createLottos(price);
        assertThat(lottos).isNotNull();
        assertThat(lottos.size()).isEqualTo(expectedAmount);
    }

    static Stream<Arguments> arrangeLottosAndSize() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        return Stream.of(
                Arguments.arguments(
                        new Lottos(Collections.emptyList()), 0,
                        new Lottos(Collections.singletonList(new Lotto((n, s) -> numbers))), 1,
                        new Lottos(Arrays.asList(new Lotto((n, s) -> numbers), new Lotto((n, s) -> numbers))), 2));
    }
}
