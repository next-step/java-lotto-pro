package study.step2.domain.numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumbersTest {

    @Test
    @DisplayName("Numbers 생성시 정수 배열만 주어지는 경우 정상적으로 생성한다")
    void create_numbers_test() {
        String[] stringNumbers = {"1", "2", "3"};

        Numbers numbers = Numbers.of(stringNumbers);

        List<Integer> mapToNumbers = Arrays.stream(stringNumbers)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        assertThat(mapToNumbers).isEqualTo(numbers.getNumbers());
    }

    @Test
    @DisplayName("Numbers 생성시 음수가 포함되어 있으면 [RuntimeException] 예외처리한다")
    void create_numbers_with_minus_test() {
        String[] stringNumbers = {"1", "-2", "3"};

        assertThatThrownBy(() -> Numbers.of(stringNumbers))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("멤버 변수로 가진 Numbers의 총합을 계산한다")
    void sum_numbers_test() {
        String[] stringNumbers = {"1", "2", "3"};

        Numbers numbers = Numbers.of(stringNumbers);

        assertThat(6).isSameAs(numbers.sum());
    }
}