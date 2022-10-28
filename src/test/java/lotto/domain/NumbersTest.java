package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumbersTest {

    @DisplayName("6개의 integer 을 입력하면 numbers 를 생성할 수 있다.")
    @ParameterizedTest
    @MethodSource("numbers_testcase")
    void numbers_size(List<Integer> integerNumbers) {

        assertThat(new Numbers(integerNumbers)).isInstanceOf(Numbers.class);
    }

    @DisplayName("입력한 integer 의 갯수가 서로 다른 6개가 아니라면 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest
    @MethodSource("numbers_fail_testcase")
    void numbers_size_valid(List<Integer> integerNumbers) {

        assertThatThrownBy(() -> new Numbers(integerNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Numbers 는 숫자 크기 오른차순으로 정렬되어 출력된다.")
    @ParameterizedTest
    @MethodSource("numbers_testcase")
    void sort_numbers(List<Integer> integerNumbers, String stringNumbers) {

        assertThat(new Numbers(integerNumbers).toString()).isEqualTo(stringNumbers);
    }


    @DisplayName("서로 다른 두 numbers 의 일하는 갯수를 확인 할 수 있다.")
    @ParameterizedTest
    @MethodSource("numbers_match_testcase")
    void numbers_match_count(List<Integer> numbers, List<Integer> compareNumbers, int expect) {

        Numbers numbers1 = new Numbers(numbers);
        Numbers numbers2 = new Numbers(compareNumbers);
        assertThat(numbers2.getMatchCount(numbers1)).isEqualTo(expect);
    }

    private static Stream<Arguments> numbers_testcase() {

        return Stream.of(
                Arguments.of(Arrays.asList(6, 5, 4, 3, 2, 1), "1, 2, 3, 4, 5, 6"),
                Arguments.of(Arrays.asList(40, 41, 42, 43, 44, 45), "40, 41, 42, 43, 44, 45"),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), "1, 2, 3, 4, 5, 6"),
                Arguments.of(Arrays.asList(45, 44, 43, 42, 41, 40), "40, 41, 42, 43, 44, 45"),
                Arguments.of(Arrays.asList(43, 23, 16, 4, 24, 5), "4, 5, 16, 23, 24, 43")
        );
    }

    private static Stream<Arguments> numbers_match_testcase() {

        return Stream.of(
                Arguments.of(Arrays.asList(6, 5, 4, 3, 2, 1), Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 9, 6), 5),
                Arguments.of(Arrays.asList(40, 41, 42, 43, 44, 45), Arrays.asList(1, 2, 40, 42, 43, 44), 4),
                Arguments.of(Arrays.asList(45, 44, 43, 42, 41, 40), Arrays.asList(40, 41, 42, 5, 6, 7), 3),
                Arguments.of(Arrays.asList(43, 23, 16, 4, 24, 5), Arrays.asList(4, 5, 1, 2, 3, 6), 2),
                Arguments.of(Arrays.asList(43, 23, 16, 4, 24, 5), Arrays.asList(10, 11, 12, 13, 14, 16), 1),
                Arguments.of(Arrays.asList(43, 23, 16, 4, 24, 5), Arrays.asList(30, 31, 32, 33, 34, 35), 0)
        );
    }

    private static Stream<Arguments> numbers_fail_testcase() {

        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 5, 6)),
                Arguments.of(Arrays.asList(6, 5, 2, 1)),
                Arguments.of(Arrays.asList(40, 41, 42, 43, 44, 45, 23)),
                Arguments.of(Arrays.asList(45, 44, 43, 42, 41, 40, 32, 54)),
                Arguments.of(Arrays.asList(43, 23)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 5))
        );
    }

}
