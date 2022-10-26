package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTicketTest {
    @Test
    @DisplayName("1개짜리 로또복권 생성")
    public void LotteryTicket_justOne() {
        LotteryTicket lotteryTicket = new LotteryTicket(1);
        assertThat(lotteryTicket.getLotteryTicket()).hasSize(1);
    }
    
    @Test
    @DisplayName("2개짜리 로또복권 생성")
    public void LotteryTicket_two() {
        LotteryTicket lotteryTicket = new LotteryTicket(2);
        assertThat(lotteryTicket.getLotteryTicket()).hasSize(2);
    }
}
