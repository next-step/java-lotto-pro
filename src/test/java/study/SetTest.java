package study;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private static final String SET_TO_STRING = "[1, 2, 3]";
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
    @DisplayName("size 메소드 : Set 크기를 반환한다")
    class SetSizeMethodTest {

        @Test
        @DisplayName("Set: " + SET_TO_STRING + ", Expected: 3")
        public void set_size_test() {
            assertThat(numbers).hasSize(3);
        }
    }

    @Nested
    @TestInstance(Lifecycle.PER_CLASS)
    @DisplayName("contains 메소드 : 주어진 값에 대해서 포함 여부를 반환한다")
    class SetContainsMethodTest {

        @ParameterizedTest(name = "Set: " + SET_TO_STRING + ", Input: [{0}], Expected: [{1}]")
        @MethodSource("set_contains_true_expected")
        @DisplayName("값이 포함되어 있으면 [true]를 리턴한다")
        public void set_contains_true_test(int input, boolean expected) {
            assertThat(numbers.contains(input)).isEqualTo(expected);
        }

        @ParameterizedTest(name = "Set: " + SET_TO_STRING + ", Input: [{0}], Expected: [{1}]")
        @MethodSource("set_contains_false_expected")
        @DisplayName("값이 포함되어 있지않으면 [false]를 리턴한다")
        public void set_contains_false_test(int input, boolean expected) {
            assertThat(numbers.contains(input)).isEqualTo(expected);
        }

        private Stream<Arguments> set_contains_true_expected() {
            return Stream.of(
                    Arguments.of(1, true),
                    Arguments.of(2, true),
                    Arguments.of(3, true)
            );
        }

        private Stream<Arguments> set_contains_false_expected() {
            return Stream.of(
                    Arguments.of(4, false),
                    Arguments.of(5, false),
                    Arguments.of(6, false)
            );
        }
    }
}
