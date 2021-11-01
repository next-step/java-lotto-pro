package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setup() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set 크기 테스트")
    void set_size() {
        assertThat(numbers.size()).isEqualTo(3);

        numbers.add(3);
        assertThat(numbers.size()).isEqualTo(3);

        numbers.add(4);
        assertThat(numbers.size()).isEqualTo(4);
    }
}
