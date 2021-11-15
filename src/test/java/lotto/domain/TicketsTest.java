package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketsTest {

    @DisplayName("로또 티켓 묶음 단건 생성")
    @Test
    void constructTickets() {
        assertThat(new Tickets(Collections.singletonList(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)))))
            .isEqualTo(new Tickets(Collections.singletonList(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)))));
    }

    @DisplayName("로또 티켓 묶음 여러 건")
    @Test
    void constructTicketsFromList() {
        Tickets expected = new Tickets(Arrays.asList(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Ticket(Arrays.asList(7, 8, 9, 10, 11, 12))));

        Tickets actual = new Tickets(Arrays.asList(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Ticket(Arrays.asList(7, 8, 9, 10, 11, 12))));

        assertThat(actual).isEqualTo(expected);
    }
}