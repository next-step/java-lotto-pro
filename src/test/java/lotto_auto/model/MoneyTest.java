package lotto_auto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MoneyTest {
    @Test
    public void 머니_숫자_이외의_값_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money("abc"))
                .withMessage(Money.NOT_NUMBER);
    }

    @Test
    public void 머니_음수_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money("-1"))
                .withMessage(Money.LESS_THAN_MIN_SIZE);
    }


}
