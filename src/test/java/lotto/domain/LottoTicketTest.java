package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {
    @Test
    @DisplayName("LottoTicket이 정해진 LottoNumber의 개수조건에 맞지 않으면 오류를 반환한다")
    void create_fail_with_wrong_count_of_lotto_number() {
        assertThatThrownBy(() -> {
            LottoTicket lottoTicket = new LottoTicket(Arrays.asList(new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("LottoTicket이 가지는 LottoNumber가 하나라도 유효한 범위가 아니라면 오류를 반환한다")
    void create_fail_with_wrong_range_of_lotto_number() {
        assertThatThrownBy(() -> {
            LottoTicket lottoTicket = new LottoTicket(Arrays.asList(new LottoNumber(0),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("LottoTicket이 가지는 LottoNumber가 하나라도 중복되면 오류를 반환한다")
    void create_fail_with_duplicated_lotto_numbers() {
        assertThatThrownBy(() -> {
            LottoTicket lottoTicket = new LottoTicket(Arrays.asList(new LottoNumber(2),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5)));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
