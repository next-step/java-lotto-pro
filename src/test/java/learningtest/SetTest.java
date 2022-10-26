package learningtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인할 수 있다")
    void testSetSize() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지 확인할 수 있다")
    @ValueSource(strings = {"1", "2", "3"})
    void testContains(int element) {
        assertThat(numbers).contains(element);
    }

    @ParameterizedTest
    @DisplayName("Set에 4, 5는 존재하지 않음을 확인할 수 있다")
    @CsvSource(value = {"1:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void testContainsElementsWithNoContains(int element, boolean isContain) {
        assertThat(numbers.contains(element)).isEqualTo(isContain);
    }
}
