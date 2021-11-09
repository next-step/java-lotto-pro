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
}