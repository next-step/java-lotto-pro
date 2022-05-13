package lotto.domain;

import org.junit.jupiter.api.Test;

import static lotto.common.Messages.MONEY_NOT_NUMBER;
import static lotto.common.Messages.POSITIVE_MONEY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class MoneyTest {

    @Test
    void 정상적인_금액_입금() {
        // given
        Money money = new Money("14000");

        // when
        int currentMoney = money.currentMoney();

        // then
        assertThat(currentMoney).isEqualTo(14000);
    }

    @Test
    void 음수인_금액_입금() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money("-1300"))
                .withMessageContaining(POSITIVE_MONEY);
    }

    @Test
    void 문자열_형태의_정상_금액_입금() {
        // given
        Money money = new Money("14000");

        // when
        int currentMoney = money.currentMoney();

        // then
        assertThat(currentMoney).isEqualTo(14000);
    }

    @Test
    void 문자열_형태의_숫자가_아닌_금액_입금() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money("asd"))
                .withMessageContaining(MONEY_NOT_NUMBER);
    }
}
