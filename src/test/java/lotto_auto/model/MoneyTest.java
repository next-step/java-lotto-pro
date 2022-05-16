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
    public void 머니_기준_값_이하_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money("900"))
                .withMessage(Money.LESS_THAN_MIN_SIZE);
    }

}
