package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @Test
    void 여러개의_로또결과를_통계낼_수_있다() {
        List<WinningRank> winningRanks = Arrays.asList(WinningRank.FIRST, WinningRank.FIRST, WinningRank.SECOND, WinningRank.FOURTH);

        Map<WinningRank, Integer> expected = new HashMap<>();
        expected.put(WinningRank.FIRST, 2);
        expected.put(WinningRank.SECOND, 1);
        expected.put(WinningRank.FOURTH, 1);

        assertThat(new LottoStatistics(winningRanks).getCountByWinningRank()).isEqualTo(expected);
    }

}