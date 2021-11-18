package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import lotto.component.SimpleLottoShuffler;
import org.junit.jupiter.api.Test;

class LottoShopTest {

    @Test
    void 로또샵은_돈을받고_로또티켓을_판매하고_판매한_로또개수를_알려줄수있다() {
        //given
        final Money money = new Money(30000);

        //when
        final LottoShop lottoShop = new LottoShop();
        final LottoTicket lottoTicket = lottoShop.sell(money, new SimpleLottoShuffler());

        //then
        assertAll(
            () -> assertThat(lottoTicket).isNotNull(),
            () -> assertThat(lottoTicket.size()).isEqualTo(money.exchangeLottoPurchasableCount()),
            () -> assertThat(lottoShop.countOfSelling()).isEqualTo(money.get())
        );
    }
}