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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SetStudyTest {

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
    @DisplayName("[요구사항 2] set에 들어있는 값의 크기를 확인한다")
    void setSize() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("[요구사항 2] set에 특정 값들이 포함되어있는지 확인한다")
    void setContainsValue(int value) {
        assertTrue(numbers.contains(value));
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    @DisplayName("[요구사항 3] set에 들어있는값이면 true 반환하고 아니면 false를 반환한다")
    void setContainCheckValue(int input, boolean expected) {
        assertEquals(numbers.contains(input), expected);
    }
}
