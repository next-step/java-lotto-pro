package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStoreTest {
    @DisplayName("가격은 음수가 아니어야 함.")
    @Test
    void 가격은_음수가_아니어야_함() {
        final int lottoUnitPrice = -100;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoStore(lottoUnitPrice))
                .withMessageContaining("금액은 음수가 아니어야 합니다.");
    }

    @DisplayName("가격은 0이 아니어야 함.")
    @Test
    void 가격은_0원이_아니어야_함() {
        final int lottoUnitPrice = 0;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoStore(lottoUnitPrice))
                .withMessageContaining("가격은 0 이상이어야 합니다.");
    }

    @DisplayName("로또 판매점 생성")
    @Test
    void 로또판매점_생성() {
        final int lottoUnitPrice = 1000;

        assertThatNoException()
                .isThrownBy(() -> new LottoStore(lottoUnitPrice));
    }
}
