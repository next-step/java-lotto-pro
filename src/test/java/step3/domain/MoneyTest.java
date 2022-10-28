package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {

    public static final Money LOTTO_PRICE = new Money(1000L);

    @Test
    void 금액은_음수일_수_없다() {
        assertThatThrownBy(() -> new Money(-1000L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액은 음수일 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"900:false", "1000:true", "1100:true"}, delimiter = ':')
    void 금액에_따라_구매가능_여부를_결정한다(long money, boolean expectedResult) {
        Money paidByUser = new Money(money);
        assertThat(paidByUser.canBuy(LOTTO_PRICE)).isEqualTo(expectedResult);
    }

    @Test
    void 결제를_하고_금액을_차감할_수_있다() {
        Money paidByUser = new Money(2000L);
        Money expectedChange = new Money(1000L);
        assertThat(paidByUser.pay(LOTTO_PRICE)).isEqualTo(expectedChange);
    }

    @Test
    void 로또_가격보다_금액이_작은경우_결제를_할_수_없다() {
        Money paidByUser = new Money(900L);
        assertThatThrownBy(() -> paidByUser.pay(LOTTO_PRICE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액은 음수일 수 없습니다.");
    }
}