package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {
    private final LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

    @Test
    @DisplayName("LottoTicket 리스트를 파라미터로 LottoTickets 객체가 생성되어야 한다")
    void create() {
        // given
        final List<LottoTicket> lottoTicketList = lottoTicketList();

        // when
        final LottoTickets lottoTickets = new LottoTickets(lottoTicketList);

        // then
        assertThat(lottoTickets).isNotNull();
        assertThat(lottoTickets).isInstanceOf(LottoTickets.class);
    }

    @Test
    @DisplayName("prizeMap 호출 시 올바른 구조의 당첨 결과 Map 객체가 반환되어야 한다")
    void prizeMap() {
        // given
        final LottoTickets lottoTickets = new LottoTickets(lottoTicketList());

        // when
        final Map<Prize, Integer> prizeMap = lottoTickets.prizeMap(lottoNumbers);

        // then
        assertThat(prizeMap.containsKey(Prize.NO_MATCHES)).isFalse();
        assertThat(prizeMap.containsKey(Prize.THREE_MATCHES)).isTrue();
        assertThat(prizeMap.containsKey(Prize.FOUR_MATCHES)).isTrue();
        assertThat(prizeMap.containsKey(Prize.FIVE_MATCHES)).isTrue();
        assertThat(prizeMap.containsKey(Prize.SIX_MATCHES)).isTrue();
        assertThat(prizeMap.keySet().size()).isEqualTo(4);
    }

    private List<LottoTicket> lottoTicketList() {
        final List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lottoTicketList.add(new LottoTicket(lottoNumbers));
        }
        return lottoTicketList;
    }
}
