package learn;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("numbers Set의 크기는 3이다.")
    void set_size_test() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("numbers Set은 숫자 1, 2, 3을 포함하고 있다.")
    void set_all_element_contains_test(int element) {
        assertThat(numbers.contains(element)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("numbers Set은 숫자 1, 2, 3을 포함하고 있지만 4, 5는 포함하지 않는다.")
    void set_some_element_contains_test(int element, boolean isContain) {
        assertThat(numbers.contains(element)).isEqualTo(isContain);
    }
}
