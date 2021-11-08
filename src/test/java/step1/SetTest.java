package step1;

import static org.assertj.core.api.Assertions.*;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("학습테스트 - Set")
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
    @DisplayName("기본으로 주어진 Set의 Size가 3인가?")
    void 기본으로_주어진_Set의_Size가_3인가() {
        //given
        final int expectedSize = 3;

        //when, then
        assertThat(numbers).hasSize(expectedSize);
    }
}
