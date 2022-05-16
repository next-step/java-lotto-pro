package camp.nextstep.edu.common;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PositiveNumbersTest {

    @Test
    void 문자열_양수와_숫자_양수로_양수_리스트_객체를_생성하면_정상_생성된다() {
        List<Long> numbers = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        List<String> stringNumbers = Arrays.asList("1", "2", "3", "4", "5");

        PositiveNumbers positiveNumbersByNumber = new PositiveNumbers(numbers);
        PositiveNumbers positiveNumbersByStringNumbers = new PositiveNumbers(stringNumbers, false);

        assertThat(positiveNumbersByNumber.sum()).isEqualTo(numbers.stream().reduce(0L, Long::sum));
        assertThat(positiveNumbersByStringNumbers.sum())
                .isEqualTo(stringNumbers.stream().mapToInt(Integer::parseInt).sum());
    }

    @Test
    void 음수가_포함된_숫자_리스트로_양수_리스트를_생성하면_예외가_발생한다() {
        List<Long> numbers = Arrays.asList(1L, 2L, -5L, 3L, -8L);

        assertThatThrownBy(() -> new PositiveNumbers(numbers)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 음수_문자열_또는_유효하지_않은_숫자_문자열로_양수_리스트를_쌩성하면_예외가_발생한다() {
        List<String> containMinusStringNumbers = Arrays.asList("-1", "3", "-4", "5", "2");
        List<String> invalidStringNumbers = Arrays.asList("1", "abc", "3", "!@#");

        assertThatThrownBy(() -> new PositiveNumbers(containMinusStringNumbers, false))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new PositiveNumbers(invalidStringNumbers, false))
                .isInstanceOf(RuntimeException.class);
    }
}
