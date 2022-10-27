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

    @DisplayName("입력한 integer 의 갯수가 6개가 아니라면 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest
    @MethodSource("numbers_fail_testcase")
    void numbers_size_valid(List<Integer> integerNumbers) {

        assertThatThrownBy(() -> new Numbers(integerNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Numbers 에 Number 가 속해 있으면 contains 결과는 true 이다.")
    @ParameterizedTest
    @MethodSource("numbers_testcase")
    void contain_numbers(List<Integer> integerNumbers, int number) {

        Numbers numbers = new Numbers(integerNumbers);
        Number from = Number.from(number);

        assertThat(numbers.contains(from)).isTrue();
    }

    @DisplayName("Numbers 는 숫자 크기 오른차순으로 정렬되어 출력된다.")
    @ParameterizedTest
    @MethodSource("numbers_testcase")
    void sort_numbers(List<Integer> integerNumbers, int unUseParam, String stringNumbers) {

        assertThat(new Numbers(integerNumbers).toString()).isEqualTo(stringNumbers);
    }

    private static Stream<Arguments> numbers_testcase() {

        return Stream.of(
                Arguments.of(Arrays.asList(6, 5, 4, 3, 2, 1), 6, "1, 2, 3, 4, 5, 6"),
                Arguments.of(Arrays.asList(40, 41, 42, 43, 44, 45), 40, "40, 41, 42, 43, 44, 45"),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 1, "1, 2, 3, 4, 5, 6"),
                Arguments.of(Arrays.asList(45, 44, 43, 42, 41, 40), 45, "40, 41, 42, 43, 44, 45"),
                Arguments.of(Arrays.asList(43, 23, 16, 4, 24, 5), 43, "4, 5, 16, 23, 24, 43")
        );
    }

    private static Stream<Arguments> numbers_fail_testcase() {

        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 5, 6)),
                Arguments.of(Arrays.asList(6, 5, 2, 1)),
                Arguments.of(Arrays.asList(40, 41, 42, 43, 44, 45, 23)),
                Arguments.of(Arrays.asList(45, 44, 43, 42, 41, 40, 32, 54)),
                Arguments.of(Arrays.asList(43, 23))
        );
    }

}
