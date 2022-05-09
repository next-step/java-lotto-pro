package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size 테스트")
    @Test
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("contains 테스트 (numbers에 있는 숫자만)")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int expectedNumber) {
        assertThat(numbers).contains(expectedNumber);
    }

    @DisplayName("contains 테스트 (numbers에 없는 숫자포함)")
    @ParameterizedTest
    @CsvSource(value = {"1=true", "2=true", "3=true", "4=false", "5=false"}, delimiter = '=')
    void contains_true_or_false(int number, boolean expectedResult) {
        assertThat(numbers.contains(number)).isEqualTo(expectedResult);
    }

}
