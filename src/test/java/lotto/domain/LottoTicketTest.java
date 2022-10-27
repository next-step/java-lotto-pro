package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoTicketTest {
    @DisplayName("로또 티켓의 번호는 6개다")
    @Test
    void lotto_ticket_number_test() {
        List<LottoNumber> numbers = Arrays.asList(
                LottoNumber.get(1),
                LottoNumber.get(2),
                LottoNumber.get(3),
                LottoNumber.get(4),
                LottoNumber.get(5),
                LottoNumber.get(6)
        );

        assertDoesNotThrow(() -> LottoTicket.create(numbers));
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
}
