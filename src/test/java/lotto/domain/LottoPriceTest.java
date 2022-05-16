package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoPriceTest {

    @Test
    void 로또는_1000원_단위로만_구매할_수_있다() {
        new LottoPrice(1000, 0);
        new LottoPrice(1000, 1);
        assertThatIllegalArgumentException().isThrownBy(() ->
                new LottoPrice(950, 1));
    }

    @Test
    void 수동구매는_총_로또구매개수보다_클_수_없다() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new LottoPrice(1000, 2));
    }

}