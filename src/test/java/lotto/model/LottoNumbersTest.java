package lotto.model;

import static lotto.model.LottoNumbers.*;
import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoNumbersTest {
    @ParameterizedTest
    @DisplayName(NUMBER_SIZE + "개의 숫자로 구성되어 있지 않을 경우 예외 발생")
    @MethodSource("provideIllegalNumbers")
    void 객체_생성_시_유효성_검사(NumberSupplier numberSupplier) {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new LottoNumbers(numberSupplier)
        ).withMessage(NUMBER_SIZE_ERR_MSG);
    }

    @ParameterizedTest
    @MethodSource("provideNumberAndExpectedResult")
    void getMatchCount(NumberSupplier numberSupplier, int expectedMatchCount) {
        LottoNumbers winningNumbers = new LottoNumbers(new ManualNumberSupplier(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers = new LottoNumbers(numberSupplier);
        assertThat(winningNumbers.getMatchCount(lottoNumbers)).isEqualTo(new MatchCount(expectedMatchCount));
    }

    private static Stream<NumberSupplier> provideIllegalNumbers() {
        return Stream.of(
            new ManualNumberSupplier(1, 2, 3, 4, 5),
            new ManualNumberSupplier(1, 2, 3, 4, 5, 6, 7)
        );
    }

    private static Stream<Arguments> provideNumberAndExpectedResult() {
        return Stream.of(
            Arguments.of(new ManualNumberSupplier(7, 8, 9, 10, 11, 12), 0),
            Arguments.of(new ManualNumberSupplier(1, 8, 9, 10, 11, 12), 1),
            Arguments.of(new ManualNumberSupplier(1, 2, 9, 10, 11, 12), 2),
            Arguments.of(new ManualNumberSupplier(1, 2, 3, 10, 11, 12), 3),
            Arguments.of(new ManualNumberSupplier(1, 2, 3, 4, 11, 12), 4),
            Arguments.of(new ManualNumberSupplier(1, 2, 3, 4, 5, 12), 5),
            Arguments.of(new ManualNumberSupplier(1, 2, 3, 4, 5, 6), 6)
        );
    }
}
