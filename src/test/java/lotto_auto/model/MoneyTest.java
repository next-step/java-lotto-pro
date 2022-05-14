package lotto_auto.model;

import lotto_auto.exception.IllegalMoneyException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MoneyTest {
    @Test
    public void 머니_숫자_이외의_값_테스트() {
        assertThatExceptionOfType(IllegalMoneyException.class)
                .isThrownBy(() -> new Money("abc"))
                .withMessage(Money.NOT_NUMBER_MSG);
    }


}
