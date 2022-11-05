package step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.LotteryTicket;
import step3.domain.Lotto;
import step3.domain.Rank;
import step3.domain.Statistics;
import step3.domain.WinningBonusNumber;

public class StatisticsTest {
    private static Statistics statistics;
    @BeforeAll
    static void beforeAll() {
        WinningBonusNumber winningBonusNumber = new WinningBonusNumber("3, 4, 5, 6, 7,8", "9");
        ArrayList<Integer> lottoNumbers4 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> lottoNumbers3 = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7));
        ArrayList<Integer> lottoNumbers2 = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 9));

        Lotto lotto4th_1 = new Lotto(lottoNumbers4);
        Lotto lotto4th_2 = new Lotto(lottoNumbers4);
        Lotto lotto3rd = new Lotto(lottoNumbers3);
        Lotto lotto2nd = new Lotto(lottoNumbers2);

        LotteryTicket lotteryTicket = new LotteryTicket();
        lotteryTicket.add(lotto4th_1);
        lotteryTicket.add(lotto4th_2);
        lotteryTicket.add(lotto3rd);
        lotteryTicket.add(lotto2nd);

        statistics = new Statistics(lotteryTicket, winningBonusNumber);
    }
    
    @Test
    @DisplayName("각 순위별 당첨 개수 확인")
    public void Statistics_count_by_rank() {
        Map<Rank, Integer> countByRank = new HashMap<>();
        countByRank.put(Rank.FIFTH,0);
        countByRank.put(Rank.FORTH,2);
        countByRank.put(Rank.THIRD,1);
        countByRank.put(Rank.SECOND,1);
        countByRank.put(Rank.FIRST,0);
    
        assertThat(statistics.countByRank()).isEqualTo(countByRank);
    }
    
    @Test
    @DisplayName("총 당첨금 확인")
    public void Statistics_total_prize() {
        assertThat(statistics.totalPrize())
                .isEqualTo(Rank.SECOND.getPrize() + Rank.THIRD.getPrize() + Rank.FORTH.getPrize() * 2);
    }

}
