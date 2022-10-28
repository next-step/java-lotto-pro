package lotto;

import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7", "1"})
    @DisplayName("6개의 숫자가 아닌 경우 IllegalArgumentException 예외 발생")
    void 로또_번호_6개_아님(String input) throws Exception {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new LottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복되는 숫자가 있는 경우 IllegalArgumentException 예외 발생")
    void 로또_번호_중복() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 1, 1, 1, 1, 1);

        assertThatThrownBy(() -> new LottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,5,7:5", "1,2,3,4,7,8:4", "1,2,3,7,8,9:3"}, delimiter = ':')
    @DisplayName("번호 일치 개수")
    void 로또_번호_일치_개수(String input, int expected) {
        LottoNumbers winLotto = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        assertThat(winLotto.getCorrectCount(numbers)).isEqualTo(expected);
    }
}
