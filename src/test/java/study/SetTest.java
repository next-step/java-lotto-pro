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

    @DisplayName("요구사항1 - set의 사이즈를 확인")
    @Test
    void matchSetSize() {
        int numbersSize = 3;
        assertThat(numbers.size()).isEqualTo(numbersSize);
    }

    @DisplayName("요구사항2 - set안의 숫자 포함 여부 확인 (set안에 add된 숫자 테스트)")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void isContains_ShouldReturnTrueForContainsNumber(int number) {
        assertTrue(numbers.contains(number));
    }

    @DisplayName("요구사항3 - set안의 숫자 포함 여부 확인 (set안에 add된 숫자 및 add되지 않은 숫자까지 테스트)")
    @ParameterizedTest(name= "{index} => number={0}, expected{1}")
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void isContains_ShouldReturnBooleanForTheExpectedValue(int number, boolean expected) {
        Boolean isContains = numbers.contains(number);
        assertEquals(isContains, expected);
    }
}
