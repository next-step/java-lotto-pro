package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void generate_성공() {
        Lotto lotto = Lotto.generate(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isNotNull();
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void generate_실패() {
        assertThatThrownBy(() -> Lotto.generate(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> Lotto.generate(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(RuntimeException.class);

    }
}
