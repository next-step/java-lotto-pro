package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    private static List<LottoTicket> manualTickets;
    private static List<LottoTicket> autoTickets;

    @BeforeAll
    static void beforeAll() {
        // manualTickets 생성
        manualTickets = new ArrayList<>();

        List<LottoNumber> ticketManual = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            ticketManual.add(new LottoNumber(i + 1));
        }
        manualTickets.add(new LottoTicket(ticketManual));

        // manualTickets 생성
        autoTickets = new ArrayList<>();

        List<LottoNumber> ticketAuto1 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            ticketAuto1.add(new LottoNumber(i + 1));
        }
        autoTickets.add(new LottoTicket(ticketAuto1));

        List<LottoNumber> ticketAuto2 = new ArrayList<>();
        for (int i = 10; i < 16; i++) {
            ticketAuto2.add(new LottoNumber(i + 1));
        }
        autoTickets.add(new LottoTicket(ticketAuto2));
    }

    @Test
    @DisplayName("LottoTickets 객체가 생성된다.")
    void createLottoTickets() {
        LottoTickets manual = new LottoTickets(manualTickets);
        LottoTickets auto = new LottoTickets(autoTickets);
        LottoTickets tickets = new LottoTickets(manual, auto);

        assertThat(tickets.getManualCount()).isEqualTo(manualTickets.size());
        assertThat(tickets.getAutoCount()).isEqualTo(autoTickets.size());
        assertThat(tickets.getLottoTickets().size()).isEqualTo(manualTickets.size() + autoTickets.size());
    }
}
