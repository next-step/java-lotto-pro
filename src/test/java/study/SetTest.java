package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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
    @DisplayName("size 메서드를 호출한다.")
    void size() {
        // when
        int size = numbers.size();

        // then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("contains 메서드를 호출한다.")
    void contains1(int input) {
        // when
        boolean result = numbers.contains(input);

        // then
        assertThat(result).isTrue();
    }
}
