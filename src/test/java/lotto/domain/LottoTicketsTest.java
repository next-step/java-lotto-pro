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
        LottoTicket winningTicket = new LottoTicket("1, 2, 3, 7, 8, 9");
        Rewards checkResult = lottoTickets.check(winningTicket);
        assertThat(checkResult.count(Rank.FOURTH)).isEqualTo(1);
        assertThat(checkResult.count(Rank.FIFTH)).isEqualTo(1);
    }
}
