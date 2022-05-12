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

    @DisplayName("size() 메소드를 활용해 Set의 크기를 확인")
    @Test
    void sizeTest01() {
        assertEquals(3, numbers.size());
    }

    @DisplayName("numbers에 1, 2, 3 값이 존재하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsTest01(int containValue) {
        assertThat(numbers.contains(containValue)).isTrue();
    }

    @DisplayName("numbers에 1, 2, 3 값이 존재만 존재하고 그 외의 값은 없는 것을 확인")
    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {
            "1,true",
            "2,true",
            "3,true",
            "4,false",
            "5,false"})
    void containsTest02(int testValue, boolean expected) {
        assertEquals(expected, numbers.contains(testValue));
    }
}
