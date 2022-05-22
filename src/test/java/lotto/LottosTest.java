package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.ui.ResultView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LottosTest {
    static Lottos lottos;

    @BeforeAll
    public static void createLottosList() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)));
        lottos = new Lottos(lottoList);
    }

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
