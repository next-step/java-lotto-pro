package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {
    @Test
    @DisplayName("티켓 개수를 파라미터로 LottoTickets 객체가 생성되어야 한다")
    void create() {
        // given
        final int amountOfTickets = 5;

        // when
        final LottoTickets lottoTickets = new LottoTickets(amountOfTickets);

        // when and then
        assertThat(lottoTickets).isInstanceOf(LottoTickets.class);
    }

    @Test
    @DisplayName("prizeMap 호출 시 올바른 구조의 당첨 결과 Map 객체가 반환되어야 한다")
    void prizeMap() {
        // given
        final int amountOfTickets = 5;
        final LottoTickets lottoTickets = new LottoTickets(amountOfTickets);
        final LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        final Map<Prize, Integer> prizeMap = lottoTickets.prizeMap(winningNumbers);

        // then
        assertThat(prizeMap.containsKey(Prize.NO_MATCHES)).isFalse();
        assertThat(prizeMap.containsKey(Prize.THREE_MATCHES)).isTrue();
        assertThat(prizeMap.containsKey(Prize.FOUR_MATCHES)).isTrue();
        assertThat(prizeMap.containsKey(Prize.FIVE_MATCHES)).isTrue();
        assertThat(prizeMap.containsKey(Prize.SIX_MATCHES)).isTrue();
        assertThat(prizeMap.keySet().size()).isEqualTo(4);
    }
}
