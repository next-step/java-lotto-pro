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

    @DisplayName("사이즈 체크")
    @Test
    void size() {
        // when
        int size = numbers.size();

        // then
        assertThat(size)
                .isEqualTo(3);
    }

    @DisplayName("값 존재 확인")
    @ParameterizedTest(name = "{displayName} ({index}) -> param = [{0}]")
    @ValueSource(ints = {1, 2, 3})
    void containsWithInnerValue(int testValue) {
        // when
        boolean testResult = numbers.contains(testValue);

        // then
        assertThat(testResult)
                .isTrue();
    }

    @DisplayName("값 존재 확인 - 미존재 값 포함")
    @ParameterizedTest(name = "{displayName} ({index}) -> param = [{0}, {1}]")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsWithExceptedResult(int testValue, boolean expectedResult) {
        // when
        boolean testResult = numbers.contains(testValue);

        // then
        assertThat(testResult)
                .isEqualTo(expectedResult);
    }
}
