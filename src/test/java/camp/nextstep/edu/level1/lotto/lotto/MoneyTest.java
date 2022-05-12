package camp.nextstep.edu.level1.lotto.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class MoneyTest {

    @Test
    void 금액은_음수일_수_없다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(-1));
    }

    @Test
    void 금액을_더하면_해당_금액만큼_증가되어야_한다() {
        long original = 10000;
        long addMoney = 5000;
        Money money = new Money(original);

        money.add(addMoney);

        assertThat(money.getValue()).isEqualTo(original + addMoney);
    }

    @Test
    void 금액을_빼면_해당_금액만큼_차감되어야_한다() {
        long original = 10000;
        long subMoney = 5000;
        Money money = new Money(original);

        money.sub(subMoney);

        assertThat(money.getValue()).isEqualTo(original - subMoney);
    }

    @Test
    void 금액을_차감한_결과가_0_미만이면_예외가_발생해야_한다() {
        long original = 5000;
        long subMoney = 10000;
        Money money = new Money(original);

        assertThatIllegalArgumentException().isThrownBy(() -> money.sub(subMoney));
    }
}
