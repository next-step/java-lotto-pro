package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    private static LottoTickets manualTickets;
    private static LottoTickets autoTickets;

    @BeforeAll
    static void beforeAll() {
        // manualTickets 생성
        List<LottoTicket> manualNumbers = new ArrayList<>();

        List<LottoNumber> ticketManual = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            ticketManual.add(new LottoNumber(i + 1));
        }
        manualNumbers.add(new LottoTicket(ticketManual));
        manualTickets = new LottoTickets(manualNumbers);

        // autoTickets 생성
        List<LottoTicket> autoNumbers = new ArrayList<>();

        List<LottoNumber> ticketAuto1 = new ArrayList<>();
        for (int i = 4; i < 10; i++) {
            ticketAuto1.add(new LottoNumber(i + 1));
        }
        autoNumbers.add(new LottoTicket(ticketAuto1));

        List<LottoNumber> ticketAuto2 = new ArrayList<>();
        for (int i = 10; i < 16; i++) {
            ticketAuto2.add(new LottoNumber(i + 1));
        }
        autoNumbers.add(new LottoTicket(ticketAuto2));
        autoTickets = new LottoTickets(autoNumbers);
    }

    @Test
    @DisplayName("LottoTickets 객체가 생성된다.")
    void createLottoTickets() {
        LottoTickets tickets = new LottoTickets(manualTickets, autoTickets);
        assertThat(tickets.size()).isEqualTo(manualTickets.size() + autoTickets.size());
    }

    @Test
    @DisplayName("로또 당첨 결과를 분석한다.")
    void checkLottoResult() {
        LottoTickets purchasedTickets = new LottoTickets(manualTickets, autoTickets);

        List<LottoNumber> winningNumbers = new ArrayList<>();
        for (int i = 7; i < 13; i++) {
            winningNumbers.add(new LottoNumber(i + 1));
        }

        LottoRanks lottoResult = purchasedTickets.lottoResult(new LottoTicket(winningNumbers), new LottoNumber(45));
        assertThat(lottoResult.prize()).isEqualTo(LottoRank.FIFTH.getPrize() * 2);
    }
}
