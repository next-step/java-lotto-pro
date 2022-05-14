package lotto.domain;

import lotto.domain.LottoPrice;
import lotto.domain.LottoStatistics;
import lotto.domain.WinningRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    private LottoStatistics lottoStatistics;

    @BeforeEach
    void setUp() {
        List<WinningRank> winningRanks = Arrays.asList(WinningRank.FIRST, WinningRank.FIRST, WinningRank.SECOND, WinningRank.FOURTH);
        lottoStatistics = new LottoStatistics(winningRanks, new LottoPrice(10000));
    }

    @Test
    void 여러개의_로또결과를_통계낼_수_있다() {
        Map<WinningRank, Integer> expected = new HashMap<>();
        expected.put(WinningRank.FIRST, 2);
        expected.put(WinningRank.SECOND, 1);
        expected.put(WinningRank.FOURTH, 1);

        assertThat(lottoStatistics.getCountByWinningRank()).isEqualTo(expected);
    }

    @Test
    void 수익율을_계산할_수_있다() {
        assertThat(lottoStatistics.calculateProfit()).isEqualTo(400150.5);
    }

}