package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 테스트")
    public void size_success() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set의 contains() 메소드를 활용해 값이 존재하는지를 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void contains_successForOnlyTrue(int num) {
        assertThat(numbers.contains(num));
    }

    @DisplayName("Set의 contains() 메소드를 활용해 입력 값에 따라 결과값이 다른 경우에 대한 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1, true", "2, true", "3, true", "4, false", "5, false"})
    public void contains_success(int num, boolean isContains) {
        assertThat(numbers.contains(num)).isEqualTo(isContains);
    }
}
