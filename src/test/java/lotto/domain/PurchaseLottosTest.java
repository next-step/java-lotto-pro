package lotto.domain;

import static lotto.LottoTestUtils.lotto;
import static lotto.LottoTestUtils.lottos;
import static lotto.LottoTestUtils.purchaseLottos;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.LottoTestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseLottosTest {

    @Test
    @DisplayName("생성 테스트")
    void of() {
        // when
        final PurchaseLottos actual = PurchaseLottos.of(lottos(lotto(1,2,3,4,5,6)), lottos(lotto(1,2,3,4,5,6), lotto(1,2,3,4,5,6)));

        // then
        assertThat(actual).isEqualTo(purchaseLottos(lottos(lotto(1,2,3,4,5,6)), lottos(lotto(1,2,3,4,5,6), lotto(1,2,3,4,5,6))));
    }
}