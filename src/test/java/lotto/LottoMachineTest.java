package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoGenerator;
import lotto.lotto.LottoNumber;
import lotto.lotto.WinningLotto;
import lotto.lotto.ManualLottoes;
import lotto.money.Money;
import lotto.view.InputView;
import lotto.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoMachine 클래스 테스트")
class LottoMachineTest {

    private final LottoGenerator lottoGenerator = () -> Lotto.of(1, 2, 3, 4, 5, 6);

    @DisplayName("LottoMachine 실행시 ResultView에 결과 주입")
    @Test
    void run() {
        final InputView stubInputView = new InputView() {
            @Override
            public Money readMoney() {
                return Money.ONE_THOUSAND;
            }

            @Override
            public ManualLottoes readManualLottoes() {
                return ManualLottoes.empty();
            }

            @Override
            public WinningLotto readPreviousWinningLotto() {
                return WinningLotto.of(Lotto.of(1, 2, 3, 4, 5, 6), LottoNumber.of(7));
            }
        };
        final ResultView stubResultView = new ResultView() {
            @Override
            public void printLottoes(List<Lotto> lottoes, int sizeOfManualLottoes) {
                assertThat(lottoes).hasSize(1);
                assertThat(sizeOfManualLottoes).isEqualTo(0);
                assertThat(lottoes).containsExactly(Lotto.of(1, 2, 3, 4, 5, 6));
            }

            @Override
            public void printResult(WinningResult winningResult, Money money) {
                assertThat(money).isEqualTo(Money.ONE_THOUSAND);
                assertThat(winningResult.find(LottoPrize.SIX_MATCH)).isEqualTo(1);
                assertThat(winningResult.rateOfReturn(money)).isEqualByComparingTo(BigDecimal.valueOf(2_000_000));
            }
        };
        final LottoMachine lottoMachine = new LottoMachine(lottoGenerator);
        lottoMachine.run(stubInputView, stubResultView);
    }
}
