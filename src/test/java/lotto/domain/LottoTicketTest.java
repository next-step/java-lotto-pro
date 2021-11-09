package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    @Test
    void 로또_티켓_생성() {
        // given
        List<Number> numbers = new ArrayList<>();
        for (int i = 1; i <= LottoTicket.LOTTO_NUMBER_COUNT; i++) {
            numbers.add(new Number(i));
        }

        // when
        LottoTicket lottoTicket = new LottoTicket(numbers);

        // then
        assertThat(lottoTicket).isNotNull();
    }

    @Test
    void 로또_티켓_생성_갯수_안맞는_경우() {
        // given
        List<Number> numbers = new ArrayList<>();

        // when, then
        assertThatThrownBy(() -> new LottoTicket(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 " + LottoTicket.LOTTO_NUMBER_COUNT + "개가 존재해야 합니다. (입력값: " + numbers.size());
    }

    @Test
    void 로또_티켓_생성_중복() {
        // given
        List<Number> numbers = new ArrayList<>();
        int duplicatedNumber = 1;
        for (int i = 1; i <= LottoTicket.LOTTO_NUMBER_COUNT; i++) {
            numbers.add(new Number(duplicatedNumber));
        }

        // when, throw
        assertThatThrownBy(() -> new LottoTicket(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 로또 번호가 입력될 수 없습니다. (입력값: " + duplicatedNumber + ")");
    }
}