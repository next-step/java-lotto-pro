package step3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTicketTest {
    private static LotteryTicket lotteryTicket;
    
    @BeforeAll
    static void beforeAll() {
        ArrayList<Integer> lottoNumbers3rd = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> lottoNumbers2nd = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7));
        ArrayList<Integer> winningNumbers = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7,8));
        Lotto lotto3rd_1 = new Lotto(lottoNumbers3rd);
        Lotto lotto3rd_2 = new Lotto(lottoNumbers3rd);
        Lotto lotto2nd = new Lotto(lottoNumbers2nd);
        
        lotteryTicket = new LotteryTicket(winningNumbers);
        lotteryTicket.add(lotto3rd_1);
        lotteryTicket.add(lotto3rd_2);
        lotteryTicket.add(lotto2nd);
    }
    @Test
    @DisplayName("3개짜리 로또복권 생성")
    public void LotteryTicket_two() {
        assertThat(lotteryTicket.getLotteryTicket()).hasSize(3);
    }
    
    @Test
    @DisplayName("각 순위별 당첨 개수 확인")
    public void LotteryTicket_count_by_rank() {
        Map<Rank, Integer> countByRank = new HashMap<>();
        countByRank.put(Rank.THIRD,2);
        countByRank.put(Rank.SECOND,1);
        
        assertThat(lotteryTicket.countByRank()).isEqualTo(countByRank);
    }
    
    @Test
    @DisplayName("2개 이상인 로또 티켓에서 총 당첨금 확인")
    public void LotteryTicket_total_prize() {
        assertThat(lotteryTicket.totalPrize()).isEqualTo(Rank.SECOND.getPrize() + Rank.THIRD.getPrize() * 2);
    }
    
}
