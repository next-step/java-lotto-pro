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

    @Test
    @DisplayName("size() 메소드를 활용해 set의 크기 확인")
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @DisplayName("contains() 메소드를 활용해 1,2,3의 값이 존재하는지 확인")
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("1,2,3 값은 true, 4,5 값을 넣으면 false 가 반환되는지 확인")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void contains_true_false(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
