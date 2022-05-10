package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

    @DisplayName("Set 의 사이즈를 확인한다.")
    @Test
    void findSetSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set 에 속한 원소를 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void findElement(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }
}
