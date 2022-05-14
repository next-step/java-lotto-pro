package study.step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMoneyTest {
    @Test
    @DisplayName("로또구매금액 생성 테스트 - 문자열")
    void create_string() {
        assertThatCode(() -> new LottoMoney("1000"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또구매금액 생성 - 숫자")
    void create_int() {
        assertThatCode(() -> new LottoMoney(1000))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또구매금액 생성 - 로또 티켓보다 작은 값")
    void create_lessThanTicketPrice() {
        assertThatThrownBy(() -> new LottoMoney(LottoMoney.LOTTO_TICKET_PRICE - 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또구매금액 생성 - 숫자가 아닌 값 문자열")
    void create_nonNumberString() {
        assertThatThrownBy(() -> new LottoMoney("만원"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구매 가능 개수 반환")
    void maxLottoTicketCount() {
        int amount = 10;
        LottoMoney lottoMoney = new LottoMoney(LottoMoney.LOTTO_TICKET_PRICE * amount);
        assertThat(lottoMoney.maxLottoTicketCount()).isEqualTo(amount);
    }

    @Test
    @DisplayName("티켓 개수로 구매 금액 확인")
    void countAmount() {
        int amount = LottoMoney.countAmount(1);
        assertThat(amount).isEqualTo(1000);
    }
}
