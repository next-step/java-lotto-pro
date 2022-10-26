package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

public class SetCollectionTest {
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
    @DisplayName("Set collection 사이즈 테스트")
    void numbersSizeCheck() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set Collection 값이 올바른지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void isCorrectNumbers(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("잘못된 Collection 값 포함 테스트")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @ParameterizedTest
    void containIncorrectNumbers(int input, boolean result) {
        assertThat(numbers.contains(input)).isEqualTo(result);
    }


}
