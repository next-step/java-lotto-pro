package study;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Set Collection에 대한 학습 테스트 클래스
 * */
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
    @DisplayName("Set 컬랙션에 대한 Size 테스트 : 중복이 제거된 사이즈가 나온다.")
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @Test
    @DisplayName("1, 2, 3 숫자가 존재하는지 테스트")
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("1, 2, 3 숫자가 존재하는지 테스트 - 중복코드 리팩토링")
    void contains(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiterString = ":")
    @DisplayName("Set 컬랙션의 숫자에 포함 여부에 대한 결과 테스트")
    void contains(Integer input, boolean result) {
        assertThat(numbers.contains(input)).isEqualTo(result);
    }

}
