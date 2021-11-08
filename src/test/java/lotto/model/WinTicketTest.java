package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinTicketTest {
    @Test
    void instantiate() {
        final List<LottoNumber> numbers = generateLottoNumberListOf(6);
        final LottoNumber bonusNumber = new LottoNumber(20);
        final WinTicket ticket = new WinTicket(numbers, bonusNumber);
        assertThat(ticket).isNotNull();
        assertThat(ticket).isInstanceOf(WinTicket.class);
        assertThat(ticket.getBonusNumber()).isEqualTo(new LottoNumber(20));
    }

    @Test
    void of() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final WinTicket ticket = WinTicket.of(numbers, 20);
        assertThat(ticket).isNotNull();
        assertThat(ticket).isInstanceOf(WinTicket.class);
        assertThat(ticket.getBonusNumber()).isEqualTo(new LottoNumber(20));
    }

    private List<LottoNumber> generateLottoNumberListOf(int count) {
        final List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }
}
