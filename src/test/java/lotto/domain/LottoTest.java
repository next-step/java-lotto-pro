package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {


    @DisplayName("서로 6개의 숫자를 입력해서 로또를 생성할 수 있다.")
    @ParameterizedTest
    @MethodSource("lotto_getMatchCount_testcase")
    void lotto(List<Integer> number) {

        assertThat(new Lotto(number)).isInstanceOf(Lotto.class);
    }

    @DisplayName("서로 다른 로또의 일치 갯수를 구할 수 있다.")
    @ParameterizedTest
    @MethodSource("lotto_getMatchCount_testcase")
    void match_count(List<Integer> numbers1, List<Integer> numbers2, int matchCount) {

        Lotto targetLotto = new Lotto(numbers1);
        Lotto compareLotto = new Lotto(numbers2);

        assertThat(targetLotto.getMatchCount(compareLotto)).isEqualTo(matchCount);
    }

    private static Stream<Arguments> lotto_getMatchCount_testcase() {

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
}
