package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class WinnerTicketTest {
    @Test
    void constructWinnerTicket() {
        WinnerTicket winnerTicket = new WinnerTicket(new LottoTicket(Arrays.asList(1,2,3,4,5,6)), new BonusNumber(new LottoNumber(7)));
        assertThat(winnerTicket).isEqualTo(new WinnerTicket(new LottoTicket(Arrays.asList(1,2,3,4,5,6)), new BonusNumber(new LottoNumber(7))));
    }
}
