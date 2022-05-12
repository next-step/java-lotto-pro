package lotto.domain;

import org.junit.jupiter.api.Test;

import static lotto.domain.LottoConstant.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @Test
    public void 로또_생성하기() {
        LottoGame.generateLotto();
    }

    @Test
    public void 로또_구매하기() {
        final int TOTAL_PRICE = 15000;
        MyLotto myLotto = LottoGame.purchaseLotto(TOTAL_PRICE);
        assertThat(myLotto.getLottoList()).hasSize(TOTAL_PRICE / LOTTO_PRICE);
    }
}
