package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTicketCreatorTest {
    @DisplayName("로또 번호 6자리를 자동 생성")
    @Test
    void createLottoTicket() {
        LotteryTicket lotteryTicket = LotteryTicketCreator.createLotteryTicket();
        assertThat(lotteryTicket.size()).isEqualTo(6);
    }
}
