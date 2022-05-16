package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.common.Messages.MONEY_NOT_NUMBER;
import static lotto.common.Messages.POSITIVE_MONEY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(strings = {"14000"})
    void 정상적인_금액_입금(String string) {
        // given
        Money money = new Money(string);

        // when
        int currentMoney = money.currentMoney();

        // then
        assertThat(currentMoney).isEqualTo(14000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1300"})
    void 음수인_금액_입금(String string) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money(string))
                .withMessageContaining(POSITIVE_MONEY);
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdf"})
    void 문자열_형태의_숫자가_아닌_금액_입금(String string) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money(string))
                .withMessageContaining(MONEY_NOT_NUMBER);
    }
}
