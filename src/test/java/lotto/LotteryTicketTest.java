package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTicketTest {
    @DisplayName("로또 티켓의 로또 번호에 당첨 번호가 몇개 있는지 세기")
    @Test
    void countMatch() {
        LotteryTicket lotteryTicket = new LotteryTicket(Arrays.asList(10, 1, 2, 3, 4, 5));
        String[] winningNumber = "1, 2, 3, 4, 5, 6".split(", ");
        assertThat(lotteryTicket.countMatch(winningNumber)).isEqualTo(5);
    }
}
