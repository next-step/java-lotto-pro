package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class WinRanksTest {
    static Lottos lottos;
    static Lotto winningLotto1;
    static Lotto winningLotto2;

    static class TestLotto extends Lotto {
        public TestLotto(List<Integer> lottoNos) {
            for (Integer lottoNo : lottoNos) {
                this.addLottoNumber(new LottoNo(lottoNo));
            }
        }
    }

    @BeforeAll
    public static void createLottosList() {
        List<Lotto> lottoSheets = new ArrayList<>();
        lottoSheets.add(new TestLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoSheets.add(new TestLotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottoSheets.add(new TestLotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
        lottoSheets.add(new TestLotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        lottoSheets.add(new TestLotto(Arrays.asList(1, 2, 7, 8, 9, 10)));
        lottos = new Lottos(lottoSheets);

        winningLotto1 = new TestLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        winningLotto2 = new TestLotto(Arrays.asList(1, 2, 3, 4, 5, 11));
    }

    @Test
    public void 당첨순위_4등_확인() {
        List<Lotto> lottoSheets = new ArrayList<>();
        lottoSheets.add(new TestLotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
        Lottos lottoRank = new Lottos(lottoSheets);

        WinRanks winRanks = new WinRanks();
        winRanks.calculateWinPriceTotals(winningLotto1, lottoRank, new LottoNo(40));
        Map<Rank, Integer> winPriceTotals = winRanks.getWinTotals();

        assertThat(winPriceTotals.get(FOURTH)).isEqualTo(1);
    }

    @Test
    public void 당첨순위_2등_확인() {
        List<Lotto> lottoSheets = new ArrayList<>();
        lottoSheets.add(new TestLotto(Arrays.asList(1, 2, 3, 4, 5, 8)));
        Lottos lottoRank = new Lottos(lottoSheets);

        WinRanks winRanks = new WinRanks();
        winRanks.calculateWinPriceTotals(winningLotto2, lottoRank, new LottoNo(8));
        Map<Rank, Integer> winPriceTotals = winRanks.getWinTotals();

        assertThat(winPriceTotals.get(SECOND)).isEqualTo(1);
    }

    @Test
    public void 당첨순위_3등_확인() {
        List<Lotto> lottoSheets = new ArrayList<>();
        lottoSheets.add(new TestLotto(Arrays.asList(1, 2, 3, 4, 5, 8)));
        Lottos lottoRank = new Lottos(lottoSheets);

        WinRanks winRanks = new WinRanks();
        winRanks.calculateWinPriceTotals(winningLotto2, lottoRank, new LottoNo(40));
        Map<Rank, Integer> winPriceTotals = winRanks.getWinTotals();

        assertThat(winPriceTotals.get(THIRD)).isEqualTo(1);
    }

    @Test
    public void 전체로또_당첨순위_확인() {
        WinRanks winRanks = new WinRanks();
        winRanks.calculateWinPriceTotals(winningLotto1, lottos, new LottoNo(30));
        Map<Rank, Integer> winPriceMap = winRanks.getWinTotals();

        assertAll(() -> assertEquals(1, winPriceMap.get(FIFTH)), () -> assertEquals(1, winPriceMap.get(FOURTH)), () -> {
            assertEquals(1, winPriceMap.get(THIRD));
        }, () -> assertEquals(1, winPriceMap.get(FIRST)));
    }

    @Test
    public void 전체로또_당첨순위_2등포함_확인() {
        WinRanks winRanks = new WinRanks();
        winRanks.calculateWinPriceTotals(winningLotto1, lottos, new LottoNo(7));
        Map<Rank, Integer> winPriceMap = winRanks.getWinTotals();

        assertAll(() -> assertEquals(1, winPriceMap.get(FIFTH)), () -> assertEquals(1, winPriceMap.get(FOURTH)),
                () -> assertEquals(1, winPriceMap.get(SECOND)), () -> assertEquals(1, winPriceMap.get(FIRST)));
    }

    @Test
    public void 전체로또_당첨금액_확인() {
        WinRanks winRanks = new WinRanks();
        int winningPrice = winRanks.winningPrice(winningLotto1, lottos, new LottoNo(40));
        assertThat(winningPrice).isEqualTo(
                FIRST.getWinningMoney() + THIRD.getWinningMoney() + FOURTH.getWinningMoney() + FIFTH.getWinningMoney());
    }

    @Test
    public void 전체로또_2등포함_당첨금액_확인() {
        WinRanks winRanks = new WinRanks();
        int winningPrice = winRanks.winningPrice(winningLotto1, lottos, new LottoNo(7));
        assertThat(winningPrice).isEqualTo(FIRST.getWinningMoney() + SECOND.getWinningMoney() + FOURTH.getWinningMoney()
                + FIFTH.getWinningMoney());
    }

    @Test
    public void 수익률_수익_확인() {
        List<Lotto> lossLottoSheet = new ArrayList<>();
        lossLottoSheet.add(new TestLotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        lossLottoSheet.add(new TestLotto(Arrays.asList(1, 2, 7, 8, 9, 10)));
        lossLottoSheet.add(new TestLotto(Arrays.asList(1, 7, 8, 9, 10, 11)));
        Lottos lossLottos = new Lottos(lossLottoSheet);

        WinRanks winRanks = new WinRanks();
        int winPrice = winRanks.winningPrice(new TestLotto(Arrays.asList(1, 2, 3, 4, 5, 6)), lossLottos,
                new LottoNo(40));
        double profitRate = winRanks.calulateProfitRate(winPrice, lossLottos.getLottosSize() * 1000);
        assertThat(profitRate).isGreaterThan(1);
    }

    @Test
    public void 수익률_손해_확인() {
        List<Lotto> winLottoSheets = new ArrayList<>();
        winLottoSheets.add(new TestLotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        winLottoSheets.add(new TestLotto(Arrays.asList(1, 2, 7, 8, 9, 10)));
        winLottoSheets.add(new TestLotto(Arrays.asList(1, 7, 8, 9, 10, 11)));
        winLottoSheets.add(new TestLotto(Arrays.asList(7, 8, 9, 10, 11, 12)));
        winLottoSheets.add(new TestLotto(Arrays.asList(8, 9, 10, 11, 12, 13)));
        winLottoSheets.add(new TestLotto(Arrays.asList(9, 10, 11, 12, 13, 14)));
        Lottos winLottos = new Lottos(winLottoSheets);

        WinRanks winRanks = new WinRanks();
        int winPrice = winRanks.winningPrice(new TestLotto(Arrays.asList(1, 2, 3, 4, 5, 6)), winLottos,
                new LottoNo(40));
        double profitRate = winRanks.calulateProfitRate(winPrice, winLottos.getLottosSize() * 1000);
        assertThat(profitRate).isLessThan(1);
    }
}