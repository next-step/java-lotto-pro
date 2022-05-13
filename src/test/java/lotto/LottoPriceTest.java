package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoPriceTest {

    @Test
    void 로또는_1000원_단위로만_구매할_수_있다() {
        new LottoPrice(1000);
        assertThatIllegalArgumentException().isThrownBy(() ->
                new LottoPrice(950));
    }

}