package study.step1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Set Collection에 대한 학습 테스트")
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

    @Nested
    @DisplayName("요구사항 1")
    class Size_테스트 {
        @Test
        @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
        void size_테스트() {
            assertThat(numbers).hasSize(3);
        }
    }

    @Nested
    @DisplayName("요구사항 2")
    class Contains_테스트1 {
        @ParameterizedTest(name = "ParameterizedTest를 활용해 Set에 {0}의 값이 존재하는지 확인한다.")
        @ValueSource(ints = {1, 2, 3})
        @DisplayName("ParameterizedTest를 활용해 Set에 값이 존재하는지 확인한다.")
        void contains_테스트(int number) {
            assertThat(numbers.contains(number)).isTrue();
        }
    }

    @Nested
    @DisplayName("요구사항 3")
    class Contains_테스트2 {
        @ParameterizedTest(name = "ParameterizedTest를 활용해 Set에 {0}의 값의 존재여부({1})를 하는지 확인한다.")
        @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
        @DisplayName("ParameterizedTest를 활용해 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.")
        void contains_테스트(int input, boolean expected) {
            assertThat(numbers.contains(input)).isEqualTo(expected);
        }
    }
}
