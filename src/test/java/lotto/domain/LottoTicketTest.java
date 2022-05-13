package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {
    @Test
    @DisplayName("LottoNumbers 객체를 파라미터로 LottoTicket 객체가 생성되어야 한다")
    void create() {
        // given
        final LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        final LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        // then
        assertThat(lottoTicket).isInstanceOf(LottoTicket.class);
        assertThat(lottoTicket).isEqualTo(new LottoTicket(lottoNumbers));
    }

    @Test
    @DisplayName("번호가 3개 미만으로 일치하면 Prize.NO_MATCHES가 반환되어야 한다")
    void when_no_matches() {
        // given
        final LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoTicket noMatchesTicket = new LottoTicket(new LottoNumbers(Arrays.asList(13, 21, 34, 37, 41, 44)));
        final LottoTicket oneMatchesTicket = new LottoTicket(new LottoNumbers(Arrays.asList(3, 21, 34, 37, 41, 44)));
        final LottoTicket twoMatchesTicket = new LottoTicket(new LottoNumbers(Arrays.asList(2, 5, 34, 37, 41, 44)));

        // when and then
        assertThat(noMatchesTicket.prize(winningNumbers)).isEqualTo(Prize.NO_MATCHES);
        assertThat(oneMatchesTicket.prize(winningNumbers)).isEqualTo(Prize.NO_MATCHES);
        assertThat(twoMatchesTicket.prize(winningNumbers)).isEqualTo(Prize.NO_MATCHES);
    }

    @Test
    @DisplayName("번호가 3개 일치하면 Prize.THREE_MATCHES이 반환되어야 한다")
    void when_three_matches() {
        // given
        final LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoTicket ticket = new LottoTicket(new LottoNumbers(Arrays.asList(2, 3, 6, 37, 41, 44)));

        // when and then
        assertThat(ticket.prize(winningNumbers)).isEqualTo(Prize.THREE_MATCHES);
    }

    @Test
    @DisplayName("번호가 4개 일치하면 Prize.FOUR_MATCHES가 반환되어야 한다")
    void when_four_matches() {
        // given
        final LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoTicket ticket = new LottoTicket(new LottoNumbers(Arrays.asList(1, 3, 5, 6, 41, 44)));

        // when and then
        assertThat(ticket.prize(winningNumbers)).isEqualTo(Prize.FOUR_MATCHES);
    }

    @Test
    @DisplayName("번호가 5개 일치하면 Prize.FIVE_MATCHES가 반환되어야 한다")
    void when_five_matches() {
        // given
        final LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoTicket ticket = new LottoTicket(new LottoNumbers(Arrays.asList(1, 3, 4, 5, 6, 44)));

        // when and then
        assertThat(ticket.prize(winningNumbers)).isEqualTo(Prize.FIVE_MATCHES);
    }

    @Test
    @DisplayName("번호가 6개 일치하면 Prize.SIX_MATCHES이 반환되어야 한다")
    void when_six_matches() {
        // given
        final LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoTicket ticket = new LottoTicket(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));

        // when and then
        assertThat(ticket.prize(winningNumbers)).isEqualTo(Prize.SIX_MATCHES);
    }
}
