package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTicketTest {
    private static final LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
    private static final BonusBall bonusBall = new BonusBall(7);

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

    @ParameterizedTest
    @MethodSource("lottoTicketMatchingLessThanThreeNumbers")
    @DisplayName("번호가 3개 미만으로 일치하면 Prize.NO_MATCHES가 반환되어야 한다")
    void when_no_matches(final LottoTicket lottoTicket) {
        // when and then
        assertThat(lottoTicket.prize(winningNumbers, bonusBall)).isEqualTo(Prize.NO_MATCHES);
    }

    @Test
    @DisplayName("번호가 3개 일치하면 Prize.THREE_MATCHES이 반환되어야 한다")
    void when_three_matches() {
        // given
        final LottoTicket ticket = new LottoTicket(new LottoNumbers(Arrays.asList(2, 3, 6, 37, 41, 44)));

        // when and then
        assertThat(ticket.prize(winningNumbers, bonusBall)).isEqualTo(Prize.THREE_MATCHES);
    }

    @Test
    @DisplayName("번호가 4개 일치하면 Prize.FOUR_MATCHES가 반환되어야 한다")
    void when_four_matches() {
        // given
        final LottoTicket ticket = new LottoTicket(new LottoNumbers(Arrays.asList(1, 3, 5, 6, 41, 44)));

        // when and then
        assertThat(ticket.prize(winningNumbers, bonusBall)).isEqualTo(Prize.FOUR_MATCHES);
    }

    @Test
    @DisplayName("번호가 5개 일치하면 Prize.FIVE_MATCHES가 반환되어야 한다")
    void when_five_matches() {
        // given
        final LottoTicket ticket = new LottoTicket(new LottoNumbers(Arrays.asList(1, 3, 4, 5, 6, 44)));

        // when and then
        assertThat(ticket.prize(winningNumbers, bonusBall)).isEqualTo(Prize.FIVE_MATCHES);
    }

    @Test
    @DisplayName("번호가 6개 일치하면 Prize.SIX_MATCHES이 반환되어야 한다")
    void when_six_matches() {
        // given
        final LottoTicket ticket = new LottoTicket(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));

        // when and then
        assertThat(ticket.prize(winningNumbers, bonusBall)).isEqualTo(Prize.SIX_MATCHES);
    }

    @Test
    @DisplayName("번호가 5개 일치하고 보너스 볼도 일치한다면 Prize.FIVE_MATCHES_WITH_BONUS_BALL가 반환되어야 한다")
    void when_five_matches_with_bonus_ball() {
        // given
        final LottoTicket ticket = new LottoTicket(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7)));

        // when and then
        assertThat(ticket.prize(winningNumbers, bonusBall)).isEqualTo(Prize.FIVE_MATCHES_WITH_BONUS_BALL);
    }

    private static Stream<Arguments> lottoTicketMatchingLessThanThreeNumbers() {
        return Stream.of(Arguments.of(new LottoTicket(new LottoNumbers(Arrays.asList(13, 21, 34, 37, 41, 44)))),
                Arguments.of(new LottoTicket(new LottoNumbers(Arrays.asList(3, 21, 34, 37, 41, 44)))),
                Arguments.of(new LottoTicket(new LottoNumbers(Arrays.asList(2, 5, 34, 37, 41, 44)))));
    }
}
