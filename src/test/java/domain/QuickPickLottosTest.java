package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class QuickPickLottosTest {
    @ParameterizedTest
    @CsvSource(value = {"10000|10", "14000|14"}, delimiter = '|')
    void 자동로또_수량_반환(int price, int size) {
        QuickPickLottos quickPickLottos = QuickPickLottos.of(price);
        assertThat(quickPickLottos.size()).isEqualTo(size);
    }

    static Stream<Arguments> arrangeQuickPickNumbersAndSize() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        return Stream.of(
                Arguments.arguments(
                        Collections.emptyList(), 0,
                        Collections.singletonList(numbers), 1,
                        Arrays.asList(numbers, numbers), 2));
    }
}
