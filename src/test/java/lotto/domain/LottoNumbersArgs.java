package lotto.domain;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

public class LottoNumbersArgs {
    protected static Stream<Arguments> lottoNumbersTest_ok() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of(Arrays.asList(40, 41, 42, 43, 44, 45))
        );
    }

    protected static Stream<Arguments> lottoNumberSizeTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }

    protected static Stream<Arguments> lottoNumberDuplicateTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 1, 1, 1, 1, 1))
        );
    }
}
