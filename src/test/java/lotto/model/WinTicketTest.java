package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinTicketTest {
    @Test
    void of_6개성공() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final WinTicket ticket = WinTicket.of(numbers, 20);
        assertThat(ticket).isNotNull();
        assertThat(ticket).isInstanceOf(WinTicket.class);
        assertThat(ticket.getBonusNumber()).isEqualTo(new LottoNumber(20));
    }

    @Test
    void of_7개실패() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> WinTicket.of(numbers, 20))
                .isInstanceOf(RuntimeException.class);
    }
}
