package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @DisplayName("로또 티켓 묶음 생성 테스트")
    @Test
    void constructLottoTickets_success() {
        assertThat(new LottoTickets(Arrays.asList(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)))))
            .isEqualTo(new LottoTickets(Arrays.asList(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)))));
    }

    @DisplayName("로또 티켓 묶음 생성 테스트")
    @Test
    void constructLottoTicketsFromList_success() {
        assertThat(new LottoTickets(Arrays.asList(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12)))))
            .isEqualTo(new LottoTickets(Arrays.asList(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12)))));
    }

    @DisplayName("로또 티켓 묶음 메시지 생성 테스트")
    @Test
    void makeMessage_success() {
        assertThat(new LottoTickets(Arrays.asList(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)))).makePrintableMessage())
            .isEqualTo("[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]");
    }
}