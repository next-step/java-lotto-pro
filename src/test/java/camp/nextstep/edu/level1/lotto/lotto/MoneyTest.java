package camp.nextstep.edu.level1.lotto.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class MoneyTest {

    @Test
    void 금액은_음수일_수_없다() {
        assertThatThrownBy(() -> new Money(-1)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 금액을_더하면_해당_금액만큼_증가되어야_한다() {
        Money originalMoney = new Money(10000);
        Money addMoney = new Money(5000);

        assertThat(originalMoney.add(addMoney)).isEqualTo(new Money(15000));
    }

    @Test
    void 금액을_빼면_해당_금액만큼_차감되어야_한다() {
        Money originalMoney = new Money(10000);
        Money subMoney = new Money(5000);

        assertThat(originalMoney.subtract(subMoney)).isEqualTo(new Money(10000 - 5000));
    }

    @Test
    void 금액을_차감한_결과가_0_미만이면_예외가_발생해야_한다() {
        Money originalMoney = new Money(5000);
        Money subMoney = new Money(10000);

        assertThatThrownBy(() -> originalMoney.subtract(subMoney)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 금액의_비율을_구하면_정상_동작해야_한다() {
        Money sourceMoney = new Money(10000);
        Money targetMoney = new Money(5000);

        assertThat(sourceMoney.calculateRateByOtherMoney(targetMoney)).isEqualTo(2.0);
    }

    @Test
    void 가지고_있는_돈으로_특정_가격의_물건을_구입할_수_있는_수량을_요청하면_정상_동작해야_한다() {
        Money money = new Money(10000);
        long price = 3333;

        assertThat(money.availablePurchaseCount(new Money(price))).isEqualTo(3);
    }

    @Test
    void _0원_이하의_물건은_구입하면_예외가_발생해야_한다() {
        Money money = new Money(10000);

        assertThatThrownBy(() -> money.availablePurchaseCount(new Money(0))).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> money.availablePurchaseCount(new Money(-1))).isInstanceOf(RuntimeException.class);
    }
}
