package step3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.LotteryTicket;
import step3.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTicketTest {
    private static LotteryTicket lotteryTicket;
    
    @BeforeAll
    static void beforeAll() {
        ArrayList<Integer> lottoNumbers3rd = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> lottoNumbers2nd = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7));
        Lotto lotto3rd = new Lotto(lottoNumbers3rd);
        Lotto lotto2nd = new Lotto(lottoNumbers2nd);
        
        lotteryTicket = new LotteryTicket(2000);
        lotteryTicket.add(lotto3rd);
        lotteryTicket.add(lotto2nd);
    }
    @Test
    @DisplayName("2개짜리 로또복권 생성")
    public void LotteryTicket_two() {
        assertThat(lotteryTicket.getLotteryTicket()).hasSize(2);
    }
    
}
