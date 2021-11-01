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
    void SetUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("집합의 크기를 확인한다")
    void sizeTest() {
        // given, when
        int setSize = numbers.size();

        // then
        assertThat(setSize).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("집합이 특정 원소를 포함하고 있는지 확인한다")
    @ValueSource(ints = {1, 2, 3})
    void containsTest(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("집합이 특정 원소를 포함하고 있는지를 확인하고 그렇지 않은 경우 예외를 발생한다")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsCsvSourceTest(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
