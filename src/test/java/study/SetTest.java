package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("size() 메소드를 활용한 크기 검증")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("contains() 메소드 검증")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    @DisplayName("contains() 메소드 결과값이 다를 때 검증")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false", "6:false"}, delimiter = ':')
    void containsTrueOrFalse(int num, boolean expected) {
        assertThat(numbers.contains(num)).isEqualTo(expected);
    }
}
