package step3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTicketTest {
    private static LotteryTicket lotteryTicket;
    
    @BeforeAll
    static void beforeAll() {
        ArrayList<Integer> lottoNumbers3rd = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> lottoNumbers2nd = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7));
        ArrayList<Integer> winningNumbers = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7,8));
        Lotto lotto3rd = new Lotto(lottoNumbers3rd);
        Lotto lotto2nd = new Lotto(lottoNumbers2nd);
        
        lotteryTicket = new LotteryTicket(winningNumbers);
        lotteryTicket.add(lotto3rd);
        lotteryTicket.add(lotto2nd);
    }
    @Test
    @DisplayName("2개짜리 로또복권 생성")
    public void LotteryTicket_two() {
        assertThat(lotteryTicket.getLotteryTicket()).hasSize(2);
    }
    
    @Test
    @DisplayName("2개 이상인 로또 티켓에서 총 당첨금 확인")
    public void LotteryTicket_two_prize() {
        assertThat(lotteryTicket.getTotalPrize()).isEqualTo(Rank.SECOND.getPrize() + Rank.THIRD.getPrize());
    }
    
    @Test
    @DisplayName("각 순위별 당첨 개수 확인")
    public void LotteryTicket_two_rankBy_count() {
    
    }
}
