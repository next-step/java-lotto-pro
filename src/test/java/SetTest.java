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

    @Test
    @DisplayName("빈 Set 객체에 1, 1, 2, 3을 add 하고 size 메서드를 호출했을 때 3이 반환되어야 한다")
    void when_call_size_should_return_3() {
        // when and then
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("빈 Set 객체에 1, 1, 2, 3을 add 하고 1, 2, 3을 파라미터로 contains 메서드를 호출했을 때 true가 반환되어야 한다")
    void when_call_contains_for_elements_in_Set_should_return_true(final int element) {
        // when and then
        assertThat(numbers.contains(element)).isTrue();
    }
}
