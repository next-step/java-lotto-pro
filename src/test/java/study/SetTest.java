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

@DisplayName("Set 클래스에 대한 학습 테스트를 작성")
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

    @DisplayName("size()를 활용해 Set의 크기를 반환")
    @Test
    void size() {
        final int actual = numbers.size();
        assertThat(actual).isEqualTo(3);
    }

    @DisplayName("contains()를 활용해 1, 2, 3의 값 포함 여부를 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int input) {
        final boolean actual = numbers.contains(input);
        assertThat(actual).isTrue();
    }

    @DisplayName("contains()를 활용해 (미)포함 여부를 확인")
    @ParameterizedTest
    @CsvSource({
            "0, false",
            "1, true",
            "2, true",
            "3, true",
            "4, false",
            "5, false"
    })
    void contains(int input, boolean expected) {
        final boolean actual = numbers.contains(input);
        assertThat(actual).isEqualTo(expected);
    }
}
