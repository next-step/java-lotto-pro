import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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

    // Test Case 구현

    @Test
    void SET의_크기는_3이어야_한다() {
        assertThat(numbers).hasSize(3);
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "SET에 포함되는 값들이 정확한지 검사 - {0}")
    @ValueSource(ints = {1, 2, 3})
    void SET에_포함되는_값들을_검사(int value) {
        assertThat(numbers).contains(value);
    }
}
