package lotto.domain;

import static lotto.domain.LottoRank.FAIL;
import static lotto.domain.LottoRank.FIRST;
import static lotto.domain.LottoRank.FOURTH;
import static lotto.domain.LottoRank.SECOND;
import static lotto.domain.LottoRank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    @DisplayName("서로 다른 6개의 숫자로 생성할 수 있다.")
    @ParameterizedTest
    @MethodSource("winning_lotto_testcase")
    void winning_lotto(List<Integer> numbers) {

        Assertions.assertThat(new WinningLotto(numbers)).isInstanceOf(WinningLotto.class);
    }


    @DisplayName("Lotto 와 비교하여 결과를 알 수 있다.")
    @ParameterizedTest
    @MethodSource("rank_testcase")
    void winning_rank(List<Integer> lottoNumber, List<Integer> winningNumber, LottoRank expect) {

        Lotto lotto = new Lotto(lottoNumber);
        WinningLotto winningLotto = new WinningLotto(winningNumber);

        assertThat(winningLotto.checkResult(lotto)).isEqualTo(expect);
    }


    private static Stream<Arguments> winning_lotto_testcase() {

        return Stream.of(
                Arguments.of(Arrays.asList(6, 5, 4, 3, 2, 1)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of(Arrays.asList(40, 41, 42, 43, 44, 45)),
                Arguments.of(Arrays.asList(45, 44, 43, 42, 41, 40)),
                Arguments.of(Arrays.asList(43, 23, 16, 4, 24, 5)),
                Arguments.of(Arrays.asList(43, 23, 16, 4, 24, 5)),
                Arguments.of(Arrays.asList(43, 23, 16, 4, 24, 5))
        );
    }


    private static Stream<Arguments> rank_testcase() {

        return Stream.of(
                Arguments.of(Arrays.asList(6, 5, 4, 3, 2, 1), Arrays.asList(1, 2, 3, 4, 5, 6), FIRST),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 9, 6), SECOND),
                Arguments.of(Arrays.asList(40, 41, 42, 43, 44, 45), Arrays.asList(1, 2, 40, 42, 43, 44), THIRD),
                Arguments.of(Arrays.asList(45, 44, 43, 42, 41, 40), Arrays.asList(40, 41, 42, 5, 6, 7), FOURTH),
                Arguments.of(Arrays.asList(43, 23, 16, 4, 24, 5), Arrays.asList(4, 5, 1, 2, 3, 6), FAIL),
                Arguments.of(Arrays.asList(43, 23, 16, 4, 24, 5), Arrays.asList(10, 11, 12, 13, 14, 16), FAIL),
                Arguments.of(Arrays.asList(43, 23, 16, 4, 24, 5), Arrays.asList(30, 31, 32, 33, 34, 35), FAIL)
        );
    }
}
