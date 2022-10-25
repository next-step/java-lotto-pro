package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.ParameterizedTest.DEFAULT_DISPLAY_NAME;

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

    @DisplayName("Set - size 메서드 테스트")
    @Test
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest(name = "Set - contains 테스트 (Parameterized value) " + DEFAULT_DISPLAY_NAME)
    @ValueSource(ints = { 1, 2, 3 })
    void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest(name = "Set - contains 테스트 (Parameterized csv) " + DEFAULT_DISPLAY_NAME)
    @CsvSource(value = { "1:true", "2:true", "3:true", "4:false", "5:false" }, delimiter = ':')
    void containsTrueOrFalse(String inputString, String expectedString) {
        //given:
        int input = Integer.parseInt(inputString);
        boolean expected = Boolean.parseBoolean(expectedString);
        //then:
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
