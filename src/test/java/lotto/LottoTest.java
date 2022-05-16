package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LottoTest {
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
    public void 로또_생성_리스트() {
        Lotto lotto = new Lotto();
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        assertThat(lottoNumbers).isSorted();
        assertThat(lottoNumbers).hasSize(6);
        assertThat(lottoNumbers).allMatch(number -> number > 0 && number < 46);
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

        int winningPrice = lottos.winningPrice(winningLotto);
        assertThat(winningPrice).isEqualTo(2000000000 + 1500000 + 50000 + 5000);
    }

    @Test
    public void 구입금액_숫자_아님_예외처리() {
        assertThatThrownBy(() -> InputView.validateMoneyInput("NotNumber")).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 구입금액_음수_예외처리_확인() {
        assertThatThrownBy(() -> InputView.validateMoneyInput("-10000")).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 수익률_수익_확인() {
        List<Lotto> lossLottoList = new ArrayList<>();
        lossLottoList.add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        lossLottoList.add(new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)));
        lossLottoList.add(new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11)));
        Lottos lossLottos = new Lottos(lossLottoList);

        int winPrice = lossLottos.winningPrice(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        double profitRate = ResultView.printProfit(lossLottos.getLottosSize() * 1000, winPrice);
        assertThat(profitRate).isGreaterThan(1);
    }

    @Test
    public void 수익률_손해_확인() {
        List<Lotto> winLottoList = new ArrayList<>();
        winLottoList.add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        winLottoList.add(new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)));
        winLottoList.add(new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11)));
        winLottoList.add(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)));
        winLottoList.add(new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13)));
        winLottoList.add(new Lotto(Arrays.asList(9, 10, 11, 12, 13, 14)));
        Lottos winLottos = new Lottos(winLottoList);

        int winPrice = winLottos.winningPrice(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        double profitRate = ResultView.printProfit(winLottos.getLottosSize() * 1000, winPrice);
        assertThat(profitRate).isLessThan(1);
    }

}
