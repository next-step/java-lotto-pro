package step3.model.machine;

import java.util.List;
import step3.model.lotto.Ticket;

public interface TicketGenerator {
    List<Integer> generateTicket(int count);
}
