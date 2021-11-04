package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningTest {

    private static Stream<Arguments> inputWinningTest() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", new Integer[]{1, 2, 3, 4, 5, 6}),
                Arguments.of("45,44,43,42,41,40", new Integer[]{40, 41, 42, 43, 44, 45})
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("당첨 번호 입력(순서 정렬)")
    public void inputWinningTest(String input, Integer[] result) {
        LottoNumbers winningNumbers = new Winning(input).getWinningNumbers();

        int[] numbers = winningNumbers.getLottoNumbers()
                .stream()
                .mapToInt(LottoNumber::getNumber)
                .toArray();

        assertThat(numbers).containsExactly(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "a,1,2,3,4,5",
            ",1,2,3,4,5,6"
    })
    @DisplayName("','부터 시작하거나 문자는 입력받을 수 없다.")
    public void inputWinningTest_fail(String input) {
        assertThatThrownBy(() -> new Winning(input)).isInstanceOf(NumberFormatException.class);
    }

}