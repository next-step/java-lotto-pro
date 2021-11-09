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
    void 객체_생성_시_유효성_검사(int[] numbers) {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new LottoNumbers(numbers)
        ).withMessageContaining(NUMBER_SIZE_ERR_MSG);
    }

    @ParameterizedTest
    @MethodSource("provideNumberAndExpectedResult")
    void getCountOfMatch(int[] numbers, int countOfMatch) {
        LottoNumbers winningNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        assertThat(winningNumbers.getCountOfMatch(lottoNumbers)).isEqualTo(countOfMatch);
    }

    private static Stream<int[]> provideIllegalNumbers() {
        return Stream.of(
            new int[] {1, 2, 3, 4, 5},
            new int[] {1, 2, 3, 4, 5, 6, 7}
        );
    }

    private static Stream<Arguments> provideNumberAndExpectedResult() {
        return Stream.of(
            Arguments.of(new int[] {7, 8, 9, 10, 11, 12}, 0),
            Arguments.of(new int[] {1, 8, 9, 10, 11, 12}, 1),
            Arguments.of(new int[] {1, 2, 9, 10, 11, 12}, 2),
            Arguments.of(new int[] {1, 2, 3, 10, 11, 12}, 3),
            Arguments.of(new int[] {1, 2, 3, 4, 11, 12}, 4),
            Arguments.of(new int[] {1, 2, 3, 4, 5, 12}, 5),
            Arguments.of(new int[] {1, 2, 3, 4, 5, 6}, 6)
        );
    }
}
