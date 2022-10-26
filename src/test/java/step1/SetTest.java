package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("numbers 의 사이즈가 3 으로 나온다.")
    void whenNumbersSize_thenThree() {
        int expectedSize = 3;
        assertThat(numbers.size()).isEqualTo(expectedSize);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    @DisplayName("임의의 수를 조회시 불값으로 리턴한다.")
    void givenPresentNumbers_whenContains_thenTrue(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
