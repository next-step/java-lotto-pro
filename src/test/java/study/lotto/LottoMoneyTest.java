package study.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMoneyTest {
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

    @Test
    @DisplayName("구매 가능한 로또 개수 확인")
    void canBuyLottos() {
        final int ticketAmount = 10;
        LottoMoney lottoMoney = new LottoMoney(LottoMoney.LOTTO_TICKET_PRICE * ticketAmount);
        assertThat(lottoMoney.canBuyLottos(ticketAmount)).isTrue();
    }

    @Test
    @DisplayName("구매 가능한 로또 개수 확인 - 0개")
    void canBuyLottos_0() {
        final int ticketAmount = 10;
        LottoMoney lottoMoney = new LottoMoney(LottoMoney.LOTTO_TICKET_PRICE * ticketAmount);
        assertThat(lottoMoney.canBuyLottos(0)).isTrue();
    }

    @Test
    @DisplayName("구매 가능한 로또 개수 확인 -  금액 초과")
    void canBuyLottos_금액초과() {
        final int ticketAmount = 10;
        LottoMoney lottoMoney = new LottoMoney(LottoMoney.LOTTO_TICKET_PRICE * ticketAmount);
        assertThat(lottoMoney.canBuyLottos(11)).isFalse();
    }

    @Test
    @DisplayName("구매 가능한 로또 개수 확인 -  개수에 음수 입력")
    void canBuyLottos_음수입력() {
        final int ticketAmount = 10;
        LottoMoney lottoMoney = new LottoMoney(LottoMoney.LOTTO_TICKET_PRICE * ticketAmount);
        boolean actual = lottoMoney.canBuyLottos(-1);
        assertThat(actual).isFalse();
    }
}
