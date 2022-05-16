package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
    public void 구입금액_입력값_숫자아님() {
        assertThatThrownBy(() -> InputView.validateMoneyInput("14000s"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 구입금액_입력값_음수() {
        assertThatThrownBy(() -> InputView.validateMoneyInput("-23000"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 당첨번호_일치개수_구하기() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        assertThat(lotto1.checkMatchCount(lotto)).isEqualTo(3);
    }

    @Test
    public void 전체로또_당첨순위_확인() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)));
        Lottos lottos = new Lottos(lottoList);

        Map<Integer, Rank> winPriceMap = lottos.calculateWinPriceMap(winningLotto);
        assertThat(winPriceMap.get(3).getCount()).isEqualTo(1);
        assertThat(winPriceMap.get(4).getCount()).isEqualTo(1);
        assertThat(winPriceMap.get(5).getCount()).isEqualTo(1);
        assertThat(winPriceMap.get(6).getCount()).isEqualTo(1);

        ResultView.printLottoResult(lottos, winningLotto);
    }

    @Test
    public void 전체로또_당첨금액_확인() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)));
        Lottos lottos = new Lottos(lottoList);

        int winningPrice = lottos.winningPrice(winningLotto);
        assertThat(winningPrice).isEqualTo(2000000000 + 1500000 + 50000 + 5000);
    }
}
