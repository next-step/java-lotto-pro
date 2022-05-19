package lotto.domain;

import lotto.domain.error.LottoTicketsErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketsTest {

    @ParameterizedTest(name = "lottoTickets 가 null 또는 empty인 경우 에러발생")
    @NullAndEmptySource
    public void lottoTickets_of_null_or_empty(List<LottoTicket> lottoTickets) {
        assertThatThrownBy(() -> {
            new LottoTickets(lottoTickets);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoTicketsErrorCode.NOT_ALLOW_NULL_OR_EMPTY.getMessage());
    }

    @Test
    @DisplayName("로또 갯수 반환 테스트")
    public void getLottoTicketsCount() {
        List<LottoTicket> lottoTickets = Arrays.asList(
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12)));

        assertThat(new LottoTickets(lottoTickets).getLottoTicketsCount()).isEqualTo(new LottoCount(lottoTickets.size()));
    }

    @Test
    @DisplayName("입력한 lottoTicket과 getLottoTickets 으로 반환한 lottoTicket 이 일치하는지 테스트")
    public void getLottoTickets() {
        LottoTicket lottoTicket1 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket2 = new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12));
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(lottoTicket1, lottoTicket2));

        assertThat(lottoTickets.getLottoTickets()).containsOnly(lottoTicket1, lottoTicket2);
    }
}