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

    @DisplayName("Set 크기 확인")
    @Test
    void set_크기_확인() {
        int expectedSize = 3;

        assertThat(numbers.size()).isEqualTo(expectedSize);
    }

    @DisplayName("Set 값 존재 확인_요구사항 방식")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void set_값_존재_확인(int checkValue) {
        assertThat(numbers.contains(checkValue)).isTrue();
    }

    @DisplayName("Set 값 존재 확인_방식2")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void set_값_존재_확인_2(int checkValue) {
        assertThat(numbers).contains(checkValue);
    }

    @DisplayName("Set 값 존재/부재 확인")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void set_값_존재_부재_확인(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}