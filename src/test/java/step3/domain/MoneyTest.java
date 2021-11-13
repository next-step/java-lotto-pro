package step3.domain;

import static helper.Constants.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @ParameterizedTest(name = DISPLAY_NAME)
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
    void _1000원권으로_로또를_할_수_있는_횟수를_얻을수있다(final int moneyOfThousand) {
        //given
        final Money money = new Money(moneyOfThousand);

        //when
        final int sellingCount = money.changeUnit();

        //then
        assertThat(money).isNotNull().isEqualTo(new Money(moneyOfThousand));
        assertThat(sellingCount).isEqualTo(moneyOfThousand / Money.THOUSAND_ONE);
    }

    @ParameterizedTest(name = DISPLAY_NAME)
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
    void 추가로돈이생기게되면_소지하고있는_돈은_늘어난다(final int additionalMoney) {
        //given
        final Money money = new Money(1000);

        //when
        money.earn(new Money(additionalMoney));

        //then
        assertThat(money).isNotNull();
        assertThat(money.get()).isEqualTo(1000 + additionalMoney);
    }
}