package lotto.domain.profit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.TestLottoNumberGenerator;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProfitTest {

    private final LottoNumber bonusNumber = LottoNumber.from(7);

    public static Stream<Arguments> winningNumbersForZero() {
        return Stream.of(
                Arguments.of(TestLottoNumberGenerator.from(Arrays.asList(17, 18, 19, 20, 27, 28)).generate()),
                Arguments.of(TestLottoNumberGenerator.from(Arrays.asList(1, 18, 19, 20, 27, 28)).generate()),
                Arguments.of(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 19, 20, 27, 28)).generate())
        );
    }

    public static Stream<Arguments> winningNumbersForLossProfit() {
        return Stream.of(
                Arguments.of(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 17, 18, 19)).generate(), true),
                Arguments.of(TestLottoNumberGenerator.from(Arrays.asList(1, 3, 5, 17, 18, 19)).generate(), false)
        );
    }

    @ParameterizedTest(name = "{index} | {displayName} | 당첨번호 = {0}")
    @MethodSource(value = "winningNumbersForZero")
    @DisplayName("수익률 0 확인 - 0개 일치/1개 일치/2개 일치")
    void profit1(List<LottoNumber> winningNumbers) {
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);
        Profit profit = Profit.of(getTestLottos(), winningLotto);

        double result = profit.profit();

        Assertions.assertThat(result).isZero();
    }

    @Test
    @DisplayName("수익률 확인 - 로또 1장이 3개 일치")
    void profit2() {
        List<LottoNumber> winningNumbers = TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 17, 18, 19)).generate();
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);
        Profit profit = Profit.of(getTestLottos(), winningLotto);

        double result = profit.profit();

        Assertions.assertThat(result).isEqualTo(0.83);
    }

    @Test
    @DisplayName("수익률 확인 - 로또 2장이 3개 일치")
    void profit3() {
        List<LottoNumber> winningNumbers = TestLottoNumberGenerator.from(Arrays.asList(1, 3, 5, 17, 18, 19)).generate();
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);
        Profit profit = Profit.of(getTestLottos(), winningLotto);

        double result = profit.profit();

        Assertions.assertThat(result).isEqualTo(1.66);
    }

    @Test
    @DisplayName("수익률 확인 - 로또 1장이 4개 일치")
    void profit5() {
        List<LottoNumber> winningNumbers = TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 4, 18, 19)).generate();
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);
        Profit profit = Profit.of(getTestLottos(), winningLotto);

        double result = profit.profit();

        Assertions.assertThat(result).isEqualTo(8.33);
    }

    @Test
    @DisplayName("수익률 확인 - 로또 1장이 5개 일치")
    void profit6() {
        List<LottoNumber> winningNumbers =
                TestLottoNumberGenerator.from(Arrays.asList(11, 12, 13, 14, 15, 18)).generate();
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);
        Profit profit = Profit.of(getTestLottos(), winningLotto);

        double result = profit.profit();

        Assertions.assertThat(result).isEqualTo(250);
    }

    @Test
    @DisplayName("수익률 확인 - 로또 1장이 6개 일치(보너스 번호가 일치)")
    void profit7() {
        List<LottoNumber> winningNumbers =
                TestLottoNumberGenerator.from(Arrays.asList(21, 22, 23, 24, 25, 28)).generate();
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);
        Profit profit = Profit.of(getTestLottos(), winningLotto);

        double result = profit.profit();

        Assertions.assertThat(result).isEqualTo(5000);
    }

    @Test
    @DisplayName("수익률 확인 - 로또 1장이 6개 일치")
    void profit8() {
        List<LottoNumber> winningNumbers =
                TestLottoNumberGenerator.from(Arrays.asList(11, 12, 13, 14, 15, 16)).generate();
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);
        Profit profit = Profit.of(getTestLottos(), winningLotto);

        double result = profit.profit();

        Assertions.assertThat(result).isEqualTo(333333.33);
    }

    @Test
    @DisplayName("수익률 확인 - 로또 2장 당첨 (3개 일치, 5개 일치)")
    void profit9() {
        List<LottoNumber> winningNumbers = TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 4, 5, 12)).generate();
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);
        Profit profit = Profit.of(getTestLottos(), winningLotto);

        double result = profit.profit();

        Assertions.assertThat(result).isEqualTo(250.83);
    }

    @ParameterizedTest(name = "{index} | {displayName} | 당첨번호 = {0}, 수익률이 1 보다 큰가? {1}")
    @MethodSource("winningNumbersForLossProfit")
    @DisplayName("수익률이 1보다 작으면 true/ 1보다 크면 false를 반환한다.")
    void lossProfit(List<LottoNumber> winningNumbers, boolean expected) {
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);
        Profit profit = Profit.of(getTestLottos(), winningLotto);
        Assertions.assertThat(profit.isLossProfit()).isEqualTo(expected);
    }

    private Lottos getTestLottos() {
        Lotto lotto1 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 4, 5, 6)).generate());
        Lotto lotto2 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(11, 12, 13, 14, 15, 16)).generate());
        Lotto lotto3 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(7, 21, 22, 23, 24, 25)).generate());
        Lotto lotto4 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(31, 32, 33, 34, 35, 36)).generate());
        Lotto lotto5 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(40, 41, 42, 43, 44, 45)).generate());
        Lotto lotto6 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(1, 3, 5, 7, 9, 11)).generate());

        return Lottos.from(Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6));
    }
}
