import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    @DisplayName("Set의 size를 확인하는 테스트")
    void getSizeOfSet() {
        assertThat(numbers.size() == 3).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Junit의 ParameterizedTest를 이용한 contains 테스트")
    @ValueSource(ints = {1, 2, 3})
    void parameterizedTest(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Junit의 ParameterizedTest를 이용한 contains 테스트2")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void parameterizedTest2(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
