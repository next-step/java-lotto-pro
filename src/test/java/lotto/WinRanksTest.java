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
        List<Lotto> lottoSheets = new ArrayList<>();
        lottoSheets.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoSheets.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottoSheets.add(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
        lottoSheets.add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        lottoSheets.add(new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)));
        lottos = new Lottos(lottoSheets);
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
    public void 당첨순위_4등_확인() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Lotto> lottoSheets = new ArrayList<>();
        lottoSheets.add(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
        Lottos lottoRank = new Lottos(lottoSheets);

        WinRanks winRanks = new WinRanks();
        winRanks.calculateWinPriceMap(winningLotto, lottoRank);
        Map<Rank, Integer> winPriceMap = winRanks.getWinMap();

        assertThat(winPriceMap.get(Rank.FOURTH)).isEqualTo(1);
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
        List<Lotto> lossLottoSheet = new ArrayList<>();
        lossLottoSheet.add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        lossLottoSheet.add(new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)));
        lossLottoSheet.add(new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11)));
        Lottos lossLottos = new Lottos(lossLottoSheet);

        WinRanks winRanks = new WinRanks();
        int winPrice = winRanks.winningPrice(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), lossLottos);
        double profitRate = ResultView.printProfit(lossLottos.getLottosSize() * 1000, winPrice);
        assertThat(profitRate).isGreaterThan(1);
    }

    @Test
    public void 수익률_손해_확인() {
        List<Lotto> winLottoSheets = new ArrayList<>();
        winLottoSheets.add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        winLottoSheets.add(new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)));
        winLottoSheets.add(new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11)));
        winLottoSheets.add(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)));
        winLottoSheets.add(new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13)));
        winLottoSheets.add(new Lotto(Arrays.asList(9, 10, 11, 12, 13, 14)));
        Lottos winLottos = new Lottos(winLottoSheets);

        WinRanks winRanks = new WinRanks();
        int winPrice = winRanks.winningPrice(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), winLottos);
        double profitRate = ResultView.printProfit(winLottos.getLottosSize() * 1000, winPrice);
        assertThat(profitRate).isLessThan(1);
    }

}
