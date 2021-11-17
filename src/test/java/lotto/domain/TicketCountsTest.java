package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketCountsTest {

    @DisplayName("티켓 개수 생성")
    @Test
    void constructTicketCounts() {
        assertThat(new TicketCounts(new TicketCount(1), new TicketCount(2)))
            .isEqualTo(new TicketCounts(new TicketCount(1), new TicketCount(2)));
    }
}
