package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.Ticket;
import lotto.util.Constants;

public class TicketTest {
    Ticket ticket;

    @BeforeEach
    public void generateTicket() {
        ticket = new Ticket();
    }

    @Test
    @DisplayName("발급로또_번호_검증_범위")
    public void ticket_num_validate_one_to_fortyfive() {
        IntStream.rangeClosed(Constants.TICKET_MIN_IDX, Constants.TICKET_MAX_IDX).forEach(i -> {
            assertThat(ticket.lottoNumbers.get(i)).isBetween(Constants.TICKET_MIN_LOTTO_NUM, Constants.TICKET_MAX_LOTTO_NUM);
        });
    }

    @Test
    @DisplayName("발급로또_번호_검증_중복")
    public void ticket_num_validate_duplicate() {
        Set<Integer> lottoSet = new HashSet<>(ticket.lottoNumbers);
        
        assertThat(lottoSet).hasSameSizeAs(ticket.lottoNumbers);
    }
}
