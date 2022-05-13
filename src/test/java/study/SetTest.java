package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트")
    @Test
    void setTest_size() {
        // given & when & then
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("contains() 메소드를 활용해 1,2,3의 값이 존재하는지를 확인하는 학습테스트")
    @Test
    void setTest_contains() {
        // given & when & then
        assertAll(
                () -> assertThat(numbers.contains(1)).isTrue(),
                () -> assertThat(numbers.contains(2)).isTrue(),
                () -> assertThat(numbers.contains(3)).isTrue()
        );
    }

    @DisplayName("ParameterizedTest를 활용해 중복 코드를 제거")
    @ParameterizedTest(name = "numbers가 {0}을 가지고 있으면 참을 반환")
    @ValueSource(ints = {1, 2, 3})
    void contains_ParameterizedTest(int value) {
        // given & when
        boolean actual = numbers.contains(value);

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("입력 값에 따라 결과 값이 다른 경우에 대한 테스트")
    @ParameterizedTest(name = "numbers가 {0}을 가지고 있는지 확인하여 {1}를 반환")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains_ParameterizedTest2(int value, boolean expected) {
        // given & when
        boolean actual = numbers.contains(value);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
