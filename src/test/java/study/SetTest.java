package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void SetTest() {
        this.numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("numbers 사이즈는 3이다")
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @DisplayName("contains 메소드를 활용해 1,2,3 값을 확인한다")
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("CsvSource를 활용해 입력값이 있는경우 true 없는 경우 false를 반환한다.")
    @CsvSource(value = {"1=true", "2=true", "3=true", "4=false", "5=false"}
            , delimiter = '=')
    void contains2(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
