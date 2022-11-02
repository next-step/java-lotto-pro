package lotto.domain;

import lotto.fixture.LottoTicketFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoTicketTest {
    @DisplayName("로또 티켓의 번호는 6개다")
    @Test
    void lotto_ticket_number_test() {
        assertDoesNotThrow(() -> LottoTicketFixture.create());
    }

    @DisplayName("로또 티켓이 6개의 번호가 아닐 경우 예외가 발생한다")
    @Test
    void lotto_ticket_number_exception_test() {
        List<LottoNumber> numbers = Arrays.asList(
                LottoNumber.get(1),
                LottoNumber.get(2),
                LottoNumber.get(3),
                LottoNumber.get(4),
                LottoNumber.get(5)
        );

        assertThatThrownBy(() -> LottoTicket.create(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호 개수는 6개여야 합니다.");
    }

    @DisplayName("로또 티켓은 다른 티켓과 번호가 몇 개 동일한지 알 수 있다")
    @Test
    void lotto_ticket_contain_test() {
        LottoTicket ticket1 = LottoTicketFixture.create();
        LottoTicket ticket2 = LottoTicketFixture.create();
        assertThat(ticket1.containCount(ticket2)).isEqualTo(6);
    }

    @DisplayName("로또 티켓은 특정 번호를 가지고 있는지 알 수 있다")
    @Test
    void lotto_number_contain_test() {
        LottoTicket ticket1 = LottoTicketFixture.create();
        assertThat(ticket1.contain(LottoNumber.get(1))).isTrue();
    }
}