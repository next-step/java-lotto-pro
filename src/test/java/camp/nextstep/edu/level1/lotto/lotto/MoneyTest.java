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
        Money originalMoney = new Money(10000);
        Money addMoney = new Money(5000);

        assertThat(originalMoney.add(addMoney)).isEqualTo(new Money(15000));
    }

    @Test
    void 금액을_빼면_해당_금액만큼_차감되어야_한다() {
        Money originalMoney = new Money(10000);
        Money subMoney = new Money(5000);

        assertThat(originalMoney.sub(subMoney)).isEqualTo(new Money(10000 - 5000));
    }

    @Test
    void 금액을_차감한_결과가_0_미만이면_예외가_발생해야_한다() {
        Money originalMoney = new Money(5000);
        Money subMoney = new Money(10000);

        assertThatIllegalArgumentException().isThrownBy(() -> originalMoney.sub(subMoney));
    }
}
