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
    @DisplayName("셋팅 되어 있는 Set 의 크기는 3이다.")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "셋팅 되어 있는 Set 은 1, 2, 3 의 값을 가지고 있다.")
    @ValueSource(ints = {1, 2, 3})
    void contains(final int testNumber) {
        assertThat(numbers.contains(testNumber));
    }

    @ParameterizedTest(name = "셋팅 되어 있는 Set 을 통한 contains 멕소드 결과는" +
            " 1, 2, 3 의 값을 가지고 있을 땐 True 그렇지 않을 떈 False 값을 반환 한다.")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiterString = ":")
    void contains(final int testNumber, final boolean expectedResult) {
        assertThat(numbers.contains(testNumber)).isEqualTo(expectedResult);
    }
}
