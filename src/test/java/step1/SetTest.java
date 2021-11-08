package step1;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.ParameterizedTest.*;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest(name = DISPLAY_NAME_PLACEHOLDER + ARGUMENTS_PLACEHOLDER)
    @ValueSource(ints = {1, 2, 3})
    void ParameterizedTest를_활용해_중복_코드를_제거_할수_있는가(int number) {
        //when, then
        assertThat(numbers.contains(number)).isTrue();
    }
}
