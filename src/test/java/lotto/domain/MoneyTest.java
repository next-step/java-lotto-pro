package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void _1000원권으로_로또를_할_수_있는_횟수를_얻을수있다() {
        //given
        final long moneyOfThousand = 30000;
        final Money money = new Money(moneyOfThousand);

        //when
        final long sellingCount = money.exchangeLottoPurchasableCount();

        //then
        assertAll(
            () -> assertThat(money).isNotNull().isEqualTo(new Money(moneyOfThousand)),
            () -> assertThat(sellingCount).isEqualTo(moneyOfThousand / Money.THOUSAND_ONE)
        );
    }

    @Test
    void 추가로돈이생기게되면_소지하고있는_돈은_늘어난다() {
        //given
        final long moneyOfThousand = 1000;
        final Money money = new Money(moneyOfThousand);

        final long additionalMoney = 30000;

        //when
        money.earn(new Money(additionalMoney));

        //then
        assertAll(
            () -> assertThat(money).isNotNull(),
            () -> assertThat(money.get()).isEqualTo(moneyOfThousand + additionalMoney)
        );
    }

    @Test
    void 돈은_마이너스가_될_수_없다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(-1)).withMessageContaining("음수");
    }
}