package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    @DisplayName("사이즈 확인하기")
    void checkSize() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest(name = "numbers에 {0} 있는지 확인하기")
    @ValueSource(ints = {1, 2, 3})
    void containsNumber(int number) {
        assertThat(numbers).contains(number);
    }

    @ParameterizedTest(name = "numbers에 {0} 포함여부의 예상된 값은 {1}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void getExpectedResultOfContains(int number, boolean expected) {
        assertEquals(expected, numbers.contains(number));
    }
}
