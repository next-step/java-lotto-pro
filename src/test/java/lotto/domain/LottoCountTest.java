package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoCountTest {

    @Test
    void 수동구매를_할_수_있다() {
        assertAll(
                () -> new LottoCount(3, new LottoPrice(10000)),
                () -> new LottoCount(0, new LottoPrice(10000))
        );

    }

    @Test
    void 수동구매는_총_로또구매개수보다_클_수_없다() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new LottoCount(2, new LottoPrice(1000))
        );
    }

    @Test
    void 수동구매는_음수가_될_수_없다() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new LottoCount(-1, new LottoPrice(1000))
        );
    }

}