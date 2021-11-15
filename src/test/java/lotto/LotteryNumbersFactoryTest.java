package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryNumbersFactoryTest {
    @DisplayName("로또 번호 6자리를 자동 생성")
    @Test
    void createLottoTicket() {
        LotteryNumbers lotteryNumbers = LotteryTicketFactory.createLotteryTicket();
        assertThat(lotteryNumbers.size()).isEqualTo(6);
    }
}
