package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void howManyLottosCanIBuyWith_3000원() {
        Money price = new Money(3_000);
        int count = Lotto.howManyLottosCanIBuyWith(price);
        assertThat(count).isEqualTo(3);
    }

    @Test
    void howManyLottosCanIBuyWith_0원() {
        Money price = new Money(0);
        int count = Lotto.howManyLottosCanIBuyWith(price);
        assertThat(count).isEqualTo(0);
    }
}
