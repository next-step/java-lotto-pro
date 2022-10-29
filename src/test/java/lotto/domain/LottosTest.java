package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {

    @DisplayName("입력한 수 만큼 자동로또를 구매할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void lottos_size(int count) {

        Lottos lottos = new Lottos(new RandomNumberPickStrategy());
        lottos.buyRandomNumberLottos(count);

        assertThat(lottos.getLottosSize()).isEqualTo(count);
    }

    @DisplayName("구매한 로또에 대한 결과를 확인할 수 있다.")
    @ParameterizedTest
    @MethodSource("result_testcase")
    void lottos_result(List<Integer> numbers, List<Integer> winningNumbers, int expect) {

        Lottos lottos = new Lottos(() -> numbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers);

        lottos.buyRandomNumberLottos(1);
        LottoResultStat lottoResultStat = lottos.checkResultStat(winningLotto);

        assertThat(lottoResultStat.totalProfit()).isEqualTo(expect);
    }

    private static Stream<Arguments> result_testcase() {

        return Stream.of(
                Arguments.of(Arrays.asList(6, 5, 4, 3, 2, 1), Arrays.asList(6, 5, 4, 3, 2, 1), 2000000),
                Arguments.of(Arrays.asList(6, 5, 4, 3, 2, 1), Arrays.asList(7, 8, 9, 10, 11, 12), 0)
        );
    }
}
