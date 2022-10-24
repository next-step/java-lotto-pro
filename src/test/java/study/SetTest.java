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

    @Test
    @DisplayName("Set의 size()를 활용해 Set의 크기를 확인")
    void set_size_test() {
        int result = numbers.size();
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set의 contains()를 활용해 1,2,3의 값이 존재하는지 확인")
    void set_contains_test(int input) {
        boolean result = numbers.contains(input);
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("입력 값에 따라 결과 값이 다른 경우에 대한 테스트가 가능하도록 구현")
    void input_test(int input, boolean expected) {
        boolean result = numbers.contains(input);
        assertThat(result).isEqualTo(expected);
    }
}
