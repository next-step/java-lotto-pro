package step3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {
    private static Statistics statistics;
    @BeforeAll
    static void beforeAll() {
        WinningNumber winningNumbers = new WinningNumber("3, 4, 5, 6, 7,8");
        ArrayList<Integer> lottoNumbers3rd = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> lottoNumbers2nd = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7));
       
        Lotto lotto3rd_1 = new Lotto(lottoNumbers3rd);
        Lotto lotto3rd_2 = new Lotto(lottoNumbers3rd);
        Lotto lotto2nd = new Lotto(lottoNumbers2nd);
    
        LotteryTicket lotteryTicket = new LotteryTicket(new Payment(3000));
        lotteryTicket.add(lotto3rd_1);
        lotteryTicket.add(lotto3rd_2);
        lotteryTicket.add(lotto2nd);
    
        statistics = new Statistics(lotteryTicket, winningNumbers);
    }
    
    @Test
    @DisplayName("각 순위별 당첨 개수 확인")
    public void Statistics_count_by_rank() {
        Map<Rank, Integer> countByRank = new HashMap<>();
        countByRank.put(Rank.FORTH,0);
        countByRank.put(Rank.THIRD,2);
        countByRank.put(Rank.SECOND,1);
        countByRank.put(Rank.FIRST,0);
    
        assertThat(statistics.countByRank()).isEqualTo(countByRank);
    }
    
    @Test
    @DisplayName("총 당첨금 확인")
    public void Statistics_total_prize() {
        assertThat(statistics.totalPrize()).isEqualTo(Rank.SECOND.getPrize() + Rank.THIRD.getPrize() * 2);
    }

}
