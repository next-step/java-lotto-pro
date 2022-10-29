package lotto.domain.profit;

import java.util.Arrays;
import java.util.List;
import lotto.domain.TestLottoNumberGenerator;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitTest {

    private final List<LottoNumber> winningNumbers =
            TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 4, 5, 6)).generate();

    @Test
    @DisplayName("수익률 확인")
    void profit() {
        Profit profit = Profit.of(getTestLottos(), winningNumbers);

        double result = profit.profit();

        Assertions.assertThat(result).isEqualTo(0.83);
    }

    @Test
    @DisplayName("수익률이 1보다 작으면 true를 반환한다.")
    void lossProfit() {
        Profit profit = Profit.of(getTestLottos(), winningNumbers);
        Assertions.assertThat(profit.isLossProfit()).isTrue();
    }

    private Lottos getTestLottos() {
        Lotto lotto1 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(8, 21, 23, 41, 42, 43)).generate());
        Lotto lotto2 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(7, 11, 16, 35, 36, 44)).generate());
        Lotto lotto3 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 19, 30, 7)).generate());
        Lotto lotto4 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(1, 15, 9, 11, 6, 8)).generate());
        Lotto lotto5 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 11, 7, 8, 9)).generate());
        Lotto lotto6 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 11, 7, 8, 9)).generate());

        return Lottos.from(Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6));
    }
}
