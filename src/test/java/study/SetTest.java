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
    void setup() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set 크기 테스트")
    void setSize() {
        assertThat(numbers.size()).isEqualTo(3);

        numbers.add(3);
        assertThat(numbers.size()).isEqualTo(3);

        numbers.add(4);
        assertThat(numbers.size()).isEqualTo(4);
    }

    public boolean isContainsNumber(int number) {
        return numbers.contains(number);
    }

    @ParameterizedTest(name = "Set 숫자 포함 테스트 {0}")
    @ValueSource(ints = {1, 2, 3})
    void setContainsNumber(int number) {
        assertTrue(isContainsNumber(number));
    }

    @ParameterizedTest(name = "Set 숫자 범위 밖 포함 테스트 {0} : {1}")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"}, delimiter = ',')
    void setContainsNumberIncludeOutOfRange(String numberString, String expectFlagString) {
        int number = Integer.parseInt(numberString);
        boolean expect = Boolean.parseBoolean(expectFlagString);
        assertEquals(isContainsNumber(number), expect);
    }
}
