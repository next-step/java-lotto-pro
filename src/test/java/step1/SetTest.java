package step1;

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

@DisplayName("Set 클래스 학습 테스트")
public class SetTest {
    @DisplayName("1, 2, 3을 값으로 가지고 있을 때")
    @Nested
    class ContextOneTwoThree {
        private Set<Integer> numbers;
        @BeforeEach
        void setUp() {
            numbers = new HashSet<>();
            numbers.add(1);
            numbers.add(1);
            numbers.add(2);
            numbers.add(3);
        }
        @DisplayName("Set 클래스의 size() 메서드는")
        @Nested
        class Describesize {
            @DisplayName("3을 반환한다.")
            @Test
            void itReturnsThree() {
                final int size = numbers.size();
                assertThat(size).isEqualTo(3);
            }
        }
        @DisplayName("Set 클래스의 contains() 메서드는")
        @Nested
        class Describecontains {
            @DisplayName("1,2,3 각 값에 대하여 true를 반환한다.")
            @ParameterizedTest
            @ValueSource(ints = {1, 2, 3})
            void itReturnsTrue(final int input) {
                assertThat(numbers.contains(input)).isTrue();
            }
            @DisplayName("1,2,3 각 값에 대하여 true, 이외의 값은 false를 반환한다.")
            @ParameterizedTest
            @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
            void itReturnsBoolean(final int input, final boolean expected) {
                final boolean result = numbers.contains(input);
                assertThat(result).isEqualTo(expected);
            }
        }
    }
}
