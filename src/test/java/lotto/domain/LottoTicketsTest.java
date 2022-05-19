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
    private static final BonusBall bonusBall = new BonusBall(7);

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
    @DisplayName("주어진 숫자 만큼의 로또 티켓들이 자동으로 생성되어야 한다")
    void create_automatically() {
        // given
        final int count = 10;

        // when
        final LottoTickets lottoTickets = LottoTickets.createAutomatically(count);

        // then
        assertThat(lottoTickets).isNotNull();
        assertThat(lottoTickets).isInstanceOf(LottoTickets.class);
    }

    @Test
    @DisplayName("LottoNumbers 리스트를 파라미터로 로또 티켓들이 생성되어야 한다")
    void create_manually() {
        // given
        final List<LottoNumbers> lottoNumbersList = Arrays.asList(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new LottoNumbers(Arrays.asList(13, 14, 15, 16, 17, 18)));

        // when
        final LottoTickets lottoTickets = LottoTickets.createManually(lottoNumbersList);

        // then
        assertThat(lottoTickets).isNotNull();
        assertThat(lottoTickets).isInstanceOf(LottoTickets.class);
    }

    @Test
    @DisplayName("LottoTickets 객체들이 서로 병합될 수 있어야 한다")
    void merge() {
        // given
        final LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        final List<LottoNumbers> lottoNumbersList = Arrays.asList(winningNumbers, winningNumbers, winningNumbers);
        final LottoTickets lottoTickets = LottoTickets.createManually(lottoNumbersList);
        final LottoTickets target = LottoTickets.createManually(lottoNumbersList);
        final BonusBall bonusBall = BonusBall.convertAndCreate("7");

        // when
        lottoTickets.merge(target);

        // then
        assertThat(lottoTickets.prizeMap(winningNumbers, bonusBall).get(Prize.SIX_MATCHES)).isEqualTo(6);
        assertThat(target.prizeMap(winningNumbers, bonusBall).get(Prize.SIX_MATCHES)).isEqualTo(3);
    }

    @Test
    @DisplayName("prizeMap 호출 시 올바른 구조의 당첨 결과 Map 객체가 반환되어야 한다")
    void prizeMap() {
        // given
        final LottoTickets lottoTickets = new LottoTickets(lottoTicketList());

        // when
        final Map<Prize, Integer> prizeMap = lottoTickets.prizeMap(lottoNumbers, bonusBall);

        // then
        assertThat(prizeMap.containsKey(Prize.NO_MATCHES)).isFalse();
        assertThat(prizeMap.containsKey(Prize.THREE_MATCHES)).isTrue();
        assertThat(prizeMap.containsKey(Prize.FOUR_MATCHES)).isTrue();
        assertThat(prizeMap.containsKey(Prize.FIVE_MATCHES)).isTrue();
        assertThat(prizeMap.containsKey(Prize.FIVE_MATCHES_WITH_BONUS_BALL)).isTrue();
        assertThat(prizeMap.containsKey(Prize.SIX_MATCHES)).isTrue();
        assertThat(prizeMap.keySet().size()).isEqualTo(5);
    }

    private List<LottoTicket> lottoTicketList() {
        final List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lottoTicketList.add(new LottoTicket(lottoNumbers));
        }
        return lottoTicketList;
    }
}
