package step3.domain;

import static helper.Constants.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.component.SimpleLottoShuffler;

class LottoShopTest {

    @ParameterizedTest(name = DISPLAY_NAME)
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
    void 로또샵은_돈을받고_로또티켓을_판매하고_판매한_로또개수를_알려줄수있다(final long moneyOfThousand) {
        //given
        final Money money = new Money(moneyOfThousand);

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