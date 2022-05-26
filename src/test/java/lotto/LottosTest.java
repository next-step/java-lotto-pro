package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.ui.ResultView;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    public void 로또_생성_자동() {
        Lottos autoLottos = new Lottos(14000);
        assertThat(autoLottos.getLottosSize()).isEqualTo(14);
    }

    @Test
    public void 금액_입력_로또_개수확인() {
        Lottos lottos = new Lottos(14000);
        ResultView.printLottoPurchase(lottos);

        assertThat(lottos.getLottosSize()).isEqualTo(14);
    }
}