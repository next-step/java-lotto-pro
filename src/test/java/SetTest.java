import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("size 메소드로 Set의 크기를 구할 수 있다")
    @Test
    void size_테스트() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("contains 메소드로 값이 존재하는지 알 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains_테스트(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }
}
