package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    public void 로또_생성() {
        Lotto lotto = new Lotto();
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        assertThat(lottoNumbers).isSorted();
        assertThat(lottoNumbers).hasSize(6);
        assertThat(lottoNumbers).allMatch(number -> number > 0 && number < 46);
    }

    @Test
    public void 금액_입력_로또_개수확인() {
        Lottos lottos = LottoMachine.createLottos(14000);
        ResultView.printLottoPurchase(lottos);

        assertThat(lottos.getLottosSize()).isEqualTo(14);
    }

    @Test
    public void 구입금액_입력값_숫자아님(){
        assertThatThrownBy(() -> InputView.validateMoneyInput("14000s"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 구입금액_입력값_음수(){
        assertThatThrownBy(() -> InputView.validateMoneyInput("-23000"))
                .isInstanceOf(RuntimeException.class);
    }
}
