package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    private LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        LottoTicket fifthTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoTicket fourthTicket = new LottoTicket("1, 2, 3, 4, 5, 7");
        lottoTickets = new LottoTickets(Arrays.asList(fifthTicket, fourthTicket));
    }

    @Test
    @DisplayName("로또_티켓_당첨_비교")
    void 로또_티켓_당첨_비교() {
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber("1, 2, 3, 7, 8, 9", 10);
        Rewards checkResult = lottoTickets.check(winningLottoNumber);
        assertThat(checkResult.count(Rank.FOURTH)).isEqualTo(1);
        assertThat(checkResult.count(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또_티켓_결합_채크")
    void 로또_티켓_결합() {
        LottoTickets manualTickets = new LottoTickets(Arrays.asList(new LottoTicket("1, 2, 3, 4, 5, 6")));
        LottoTickets autoTickets = new LottoTickets(Arrays.asList(new LottoTicket("1, 2, 3, 4, 5, 7")));
        assertThat(manualTickets.merge(autoTickets)).isEqualTo(lottoTickets); ;
    }
}
