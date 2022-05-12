package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set은 중복된 데이터를 허용하지 않는다.")
    void size_test() {
        // given - when - then
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest(name = "numbers {0} 값이 담겨져 있다.")
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("numbers 1,2,3 값이 담겨져 있다.")
    void contains_test(int input) {
        // given - when - then
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("numbers 1,2,3 값이 담겨져 있으며  4,5 값은 담겨져 있지 않다.")
    void contains_false_test(int input, boolean result) {
        // given - when - then
        assertThat(numbers.contains(input)).isEqualTo(result);
    }
}
