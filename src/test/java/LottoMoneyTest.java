import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoMoneyTest {
    @Test
    void 빈_Money_를_생성할_수_있다() {
        assertDoesNotThrow(LottoMoney::empty);
    }

    @Test
    void 금액을_가진_Money_를_생성할_수_있다() {
        assertDoesNotThrow(() -> LottoMoney.of(Integer.MAX_VALUE));
        assertThrows(IllegalArgumentException.class, () -> LottoMoney.of(Integer.MIN_VALUE));
    }

    @Test
    void 로또를_살_수_있는지_확인할_수_있다() {
        assertThat(LottoMoney.empty().canBuy()).isFalse();
        assertThat(LottoMoney.of(Integer.MAX_VALUE).canBuy()).isTrue();
    }

    @Test
    void 금액이_로또가격보다_크거나_같다면_로또를_살_수_있다() {
        assertDoesNotThrow(() -> LottoMoney.empty().buy(Lotto.empty()));
        assertDoesNotThrow(() -> LottoMoney.of(Vendor.LOTTO_PRICE).buyOne());
    }

    @Test
    void 금액이_로또가격보다_작다면_로또를_살_수_없다() {
        assertThatThrownBy(() -> LottoMoney.empty().buyOne());
        assertThatThrownBy(() -> LottoMoney.of(Vendor.LOTTO_PRICE - 1).buyOne());
    }

}
