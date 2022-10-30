package step3.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.model.machine.Result;

class TicketsTest {
    private Lotto lotto;
    private List<Ticket> ticketList = new ArrayList<>();

    @BeforeEach
    void setup() {
        lotto = new Lotto("1,2,3,4,5,6");
        Ticket ticket_match_6 = new Ticket(Arrays.asList(1,2,3,4,5,6));
        Ticket ticket_match_4 = new Ticket(Arrays.asList(3,4,5,6,7,8));
        Ticket ticket_match_2 = new Ticket(Arrays.asList(5,6,7,8,9,10));
        ticketList.addAll(Arrays.asList(ticket_match_6, ticket_match_4, ticket_match_2));

    }
    @Test
    void 티켓생성_성공() {
        Tickets tickets = new Tickets(ticketList);
        assertThat(tickets).isEqualTo(new Tickets(ticketList));
    }

    @Test
    void 매치만_같으면_결과는_같다() {
        Tickets tickets = new Tickets(ticketList);
        Collections.shuffle(ticketList);
        Tickets tickets2 = new Tickets(ticketList);
        assertThat(tickets.getResults(lotto)).isEqualTo(tickets2.getResults(lotto));
    }


}