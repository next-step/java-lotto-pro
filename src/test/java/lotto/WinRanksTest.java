package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.ui.ResultView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class WinRanksTest {
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
    public void 전체로또_당첨순위_확인() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        WinRanks winRanks = new WinRanks();
        winRanks.calculateWinPriceMap(winningLotto, lottos);
        Map<Rank, Integer> winPriceMap = winRanks.getWinMap();

        assertThat(winPriceMap.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(winPriceMap.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(winPriceMap.get(Rank.THIRD)).isEqualTo(1);
        assertThat(winPriceMap.get(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    public void 전체로또_당첨금액_확인() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinRanks winRanks = new WinRanks();
        int winningPrice = winRanks.winningPrice(winningLotto, lottos);
        assertThat(winningPrice).isEqualTo(2_000_000_000 + 1_500_000 + 50_000 + 5_000);
    }

    @Test
    public void 수익률_수익_확인() {
        List<Lotto> lossLottoList = new ArrayList<>();
        lossLottoList.add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        lossLottoList.add(new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)));
        lossLottoList.add(new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11)));
        Lottos lossLottos = new Lottos(lossLottoList);

        WinRanks winRanks = new WinRanks();
        int winPrice = winRanks.winningPrice(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), lossLottos);
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

        WinRanks winRanks = new WinRanks();
        int winPrice = winRanks.winningPrice(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), winLottos);
        double profitRate = ResultView.printProfit(winLottos.getLottosSize() * 1000, winPrice);
        assertThat(profitRate).isLessThan(1);
    }

}
