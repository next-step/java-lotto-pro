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

    @DisplayName("Set에 담긴 값의 갯수를 반환한다")
    @Test
    void testSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set에 담긴 값이 있으면 true를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testContainsWithValueSource(Integer value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @DisplayName("Set에 담긴 값이 있으면 true를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void testContainsWithCsvSource(String input, String expected) {
        assertThat(numbers.contains(Integer.parseInt(input))).isEqualTo(Boolean.parseBoolean(expected));
    }
}
