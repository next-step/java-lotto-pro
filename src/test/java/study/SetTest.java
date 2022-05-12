package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest {
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
    @DisplayName("요구사항_1: Set 의 size() 메소드를 활용해 Set 의 크기 테스트")
    void set_size_test() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("요구사항_2: Set 의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지")
    void set_contains_test() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항_2: Set 의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지 - 중복제거")
    void set_contains_test_short_way(Integer number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("요구사항_3: 입력 값에 따라 결과 값이 다른 경우에 대한 테스트")
    void set_contains_true_false_test(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
