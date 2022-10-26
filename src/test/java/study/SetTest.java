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
    void setup() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("numbers 셋의 크기는 3 이다")
    void setSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("numbers 셋에 해당값이 들어있다 - ValueSource 활용한 ParameterizedTest")
    @ValueSource(ints = {1, 2, 3})
    void setContainsOneTwoThreeValueSource(Integer value) {
        assertThat(numbers).contains(value);
    }

    @ParameterizedTest
    @DisplayName("numbers 셋에 해당값이 들어있지 않다 - ValueSource 활용한 ParameterizedTest")
    @ValueSource(ints = {0, 4, 5})
    void setNotContainsZeroFourFiveValueSource(Integer value) {
        assertThat(numbers).doesNotContain(value);
    }

    @ParameterizedTest
    @DisplayName("numbers 셋에 해당값이 들어있다 - CsvSource 활용한 ParameterizedTest")
    @CsvSource(value = {"1:true", "2:true", "3:true"}, delimiter = ':')
    void setContainsOneTwoThreeCsvSource(Integer value, Boolean expected) {
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("numbers 셋에 해당값이 들어있지 않다 - CsvSource 활용한 ParameterizedTest")
    @CsvSource(value = {"0:false", "4:false", "5:false"}, delimiter = ':')
    void setNotContainsZeroFourFive(Integer value, Boolean expected) {
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }
}
