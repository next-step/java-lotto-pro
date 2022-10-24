import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("size를 확인하는 테스트")
    void size_test() {
        // Given
        int result;

        // When
        result = 3;

        // Then
        assertThat(numbers.size()).isEqualTo(result);
    }

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("정해진 숫자를 포함하는지 확인하는 테스트")
    void contain_test(int input) {
        // When & Then
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = { "1=true", "2=true", "3=true", "4=false", "5=false" }, delimiter = '=')
    void csv_source_contain_test(int input, boolean expected) {
        // When & Then
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
