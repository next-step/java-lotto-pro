package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketVendingMachineTest {

    @Test
    @DisplayName("자동으로 로또 티켓을 생성한다.")
    void auto_issue_tickets() {
        //given
        int autoTicketAmount = 5;
        LottoTicketVendingMachine vendingMachine = new LottoTicketVendingMachine();

        //when
        LottoTickets lottoTickets = vendingMachine.issueTickets(autoTicketAmount);

        //then
        assertThat(lottoTickets.getLottoTickets()).hasSize(5);
    }
}