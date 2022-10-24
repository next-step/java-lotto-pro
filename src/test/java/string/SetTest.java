package string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Set 클래스에 대한 학습 테스트")
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
    @DisplayName("size() 메소드를 활용해 Set의 크기가 반환되는지 확인")
    void size() {
        // when
        int results = numbers.size();

        // then
        assertThat(results).isEqualTo(3);
    }

    @Test
    @DisplayName("contain 메소드를 활용해 특정 값이 포함되는지 확인")
    void contains1() {
        // when & then
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("ParameterizedTest & ValueSource 활용하여 중복코드 제거하고, contain 메소드 정상적으로 동작하는지 확인")
    @ParameterizedTest(name ="{index} {displayName} {arguments}")
    @ValueSource(ints = {1, 2, 3})
    void contains2(int input) {
        // when
        boolean result = numbers.contains(input);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("ParameterizedTest & CsvSource 활용하여 중복코드 제거하고, contain 메소드 정상적으로 동작하는지 확인")
    @ParameterizedTest(name ="{index} {displayName} input={arguments} ")
    @CsvSource(value = {"1>true", "2>true", "3>true", "4>false", "5>false"}, delimiter = '>')
    void contains3(int input, boolean expected) {
        // when
        boolean result = numbers.contains(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}