package lotto.domain;

import lotto.domain.error.LottoTicketsErrorCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketsTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void lottoTickets_of_null_or_empty(List<LottoTicket> lottoTickets) {
        assertThatThrownBy(() -> {
            new LottoTickets(lottoTickets);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoTicketsErrorCode.NOT_ALLOW_NULL_OR_EMPTY.getMessage());
    }

    @Test
    public void getLottoTicketsCount() {
        List<LottoTicket> lottoTickets = Arrays.asList(
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12)));

        assertThat(new LottoTickets(lottoTickets).getLottoTicketsCount()).isEqualTo(new LottoCount(lottoTickets.size()));
    }

    @Test
    public void getLottoTickets() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket1 = new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12));
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(lottoTicket, lottoTicket1));

        assertThat(lottoTickets.getLottoTickets()).containsOnly(lottoTicket, lottoTicket1);
    }
}