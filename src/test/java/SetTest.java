import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
