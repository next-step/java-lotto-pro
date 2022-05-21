package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
<<<<<<< HEAD
        winRanks.calculateWinPriceTotals(winningLotto, lottos, 30);
        Map<Rank, Integer> winPriceMap = winRanks.getWinTotals();
=======
        winRanks.calculateWinPriceMap(winningLotto, lottos);
        Map<Rank, Integer> winPriceMap = winRanks.getWinMap();
>>>>>>> 119371d (refactor : Rank enum으로 변경)

        assertThat(winPriceMap.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(winPriceMap.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(winPriceMap.get(Rank.THIRD)).isEqualTo(1);
        assertThat(winPriceMap.get(Rank.FIRST)).isEqualTo(1);
<<<<<<< HEAD
    }

    @Test
    public void 전체로또_당첨순위_2등포함_확인() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        WinRanks winRanks = new WinRanks();
        winRanks.calculateWinPriceTotals(winningLotto, lottos, 7);
        Map<Rank, Integer> winPriceMap = winRanks.getWinTotals();

        assertThat(winPriceMap.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(winPriceMap.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(winPriceMap.get(Rank.SECOND)).isEqualTo(1);
        assertThat(winPriceMap.get(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    public void 당첨순위_4등_확인() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Lotto> lottoSheets = new ArrayList<>();
        lottoSheets.add(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
        Lottos lottoRank = new Lottos(lottoSheets);

        WinRanks winRanks = new WinRanks();
        winRanks.calculateWinPriceTotals(winningLotto, lottoRank, 40);
        Map<Rank, Integer> winPriceTotals = winRanks.getWinTotals();

        assertThat(winPriceTotals.get(Rank.FOURTH)).isEqualTo(1);
    }

    @Test
    public void 당첨순위_2등_확인() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 11));

        List<Lotto> lottoSheets = new ArrayList<>();
        lottoSheets.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)));
        Lottos lottoRank = new Lottos(lottoSheets);

        WinRanks winRanks = new WinRanks();
        winRanks.calculateWinPriceTotals(winningLotto, lottoRank, 8);
        Map<Rank, Integer> winPriceTotals = winRanks.getWinTotals();

        assertThat(winPriceTotals.get(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    public void 당첨순위_3등_확인() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 11));

        List<Lotto> lottoSheets = new ArrayList<>();
        lottoSheets.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)));
        Lottos lottoRank = new Lottos(lottoSheets);

        WinRanks winRanks = new WinRanks();
        winRanks.calculateWinPriceTotals(winningLotto, lottoRank, 40);
        Map<Rank, Integer> winPriceTotals = winRanks.getWinTotals();

        assertThat(winPriceTotals.get(Rank.THIRD)).isEqualTo(1);
=======
>>>>>>> 119371d (refactor : Rank enum으로 변경)
    }

    @Test
    public void 전체로또_당첨금액_확인() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinRanks winRanks = new WinRanks();
<<<<<<< HEAD
        int winningPrice = winRanks.winningPrice(winningLotto, lottos, 40);
        assertThat(winningPrice).isEqualTo(2_000_000_000 + 1_500_000 + 50_000 + 5_000);
    }

    @Test
    public void 전체로또_2등포함_당첨금액_확인() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinRanks winRanks = new WinRanks();
        int winningPrice = winRanks.winningPrice(winningLotto, lottos, 7);
        assertThat(winningPrice).isEqualTo(
                Rank.FIRST.getWinningMoney() + Rank.SECOND.getWinningMoney() + Rank.FOURTH.getWinningMoney()
                        + Rank.FIFTH.getWinningMoney());
=======
        int winningPrice = winRanks.winningPrice(winningLotto, lottos);
        assertThat(winningPrice).isEqualTo(2_000_000_000 + 1_500_000 + 50_000 + 5_000);
>>>>>>> 119371d (refactor : Rank enum으로 변경)
    }

    @Test
    public void 수익률_수익_확인() {
        List<Lotto> lossLottoSheet = new ArrayList<>();
        lossLottoSheet.add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        lossLottoSheet.add(new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)));
        lossLottoSheet.add(new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11)));
        Lottos lossLottos = new Lottos(lossLottoSheet);

        WinRanks winRanks = new WinRanks();
        int winPrice = winRanks.winningPrice(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), lossLottos, 40);
        String profitRate = winRanks.calulateProfitRate(winPrice, lossLottos.getLottosSize() * 1000);
        assertThat(Double.parseDouble(profitRate)).isGreaterThan(1);
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
        int winPrice = winRanks.winningPrice(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), winLottos, 40);
        String profitRate = winRanks.calulateProfitRate(winPrice, winLottos.getLottosSize() * 1000);
        assertThat(Double.parseDouble(profitRate)).isLessThan(1);
    }
}
