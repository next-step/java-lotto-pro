package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {
    @Test
    @DisplayName("구매한 티켓의 당첨 결과를 확인한다.")
    void check_winning_results_test() {
        List<Number> lottoNumbers = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        LottoGenerator lottoGenerator = () -> new Lotto(lottoNumbers);

        Lotto lotto = lottoGenerator.generateLotto();
        LottoPaper lottoPaper = new LottoPaper(Arrays.asList(lotto));
        WinningResult winningResult = new WinningResult(lottoPaper, "1, 2, 3, 4, 5, 6");

        assertThat(winningResult.winningReport().awardResult().get(Award.FIRST)).isEqualTo(1);
        assertThat(winningResult.winningReport().rateOfReturn()).isNotNull();
    }
}
