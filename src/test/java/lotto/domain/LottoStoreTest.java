package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {
    @Test
    @DisplayName("로또_티켓_구매")
    void 로또_티켓_구매() {
        LottoTicket buyTicket = LottoStore.ticketPrinting(() -> new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Set<LottoNumber> lottoTicket = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());
        assertThat(buyTicket).isEqualTo(new LottoTicket(lottoTicket));
    }

    @Test
    @DisplayName("수동_로또_티켓_구매")
    void 수동_로또_티켓_구매() {
        LottoStore lottoStore = new LottoStore(new RandomLottoNumberGenerateStrategy());
        LottoTickets lottoTicket = new LottoTickets(new ArrayList<>(Arrays.asList(new LottoTicket("1, 2, 3, 4, 5, 6"))));
        LottoTickets manualTickets = lottoStore.buy(new ArrayList<>(Arrays.asList("1, 2, 3, 4, 5, 6")));
        assertThat(manualTickets).isEqualTo(lottoTicket);
    }
}
