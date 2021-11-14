package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @DisplayName("로또 티켓 묶음 단건 생성")
    @Test
    void constructLottoTickets() {
        assertThat(new LottoTickets(Collections.singletonList(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)))))
            .isEqualTo(new LottoTickets(Collections.singletonList(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)))));
    }

    @DisplayName("로또 티켓 묶음 여러 건")
    @Test
    void constructLottoTicketsFromList() {
        assertThat(new LottoTickets(Arrays.asList(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12)))))
            .isEqualTo(new LottoTickets(Arrays.asList(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12)))));
    }
}