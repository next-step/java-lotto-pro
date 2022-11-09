package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.strategy.LottoRandomCreateStrategy;
import org.junit.jupiter.api.Test;

class LottoShopTest {

    @Test
    void 제공한_금액만큼_로또를_제공한다() {
        LottoShop lottoShop = new LottoShop(new LottoRandomCreateStrategy());
        Lottos lottos = lottoShop.buy(new Money(14000));

        assertThat(lottos.count()).isEqualTo(14);
    }

}
