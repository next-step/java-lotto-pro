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

    @DisplayName("numbers 의 사이즈는 3")
    @Test
    void numbers_size() {
        int result = numbers.size();
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest(name = "numbers 는 {0} 포함")
    @ValueSource(ints = {1, 2, 3})
    void set_contains(int input) {
        assertThat(numbers).contains(input);
    }

    @ParameterizedTest(name = "number 에 {0} contains() -> {1}")
    @CsvSource(value = {"0:false", "1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    void set_contains_true_false(int input, boolean expect) {
        assertThat(numbers.contains(input)).isEqualTo(expect);
    }

}
