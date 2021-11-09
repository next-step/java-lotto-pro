package step3.domain;

import static helper.Constants.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoShopTest {

    @ParameterizedTest(name = DISPLAY_NAME)
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
    void 로또샵은_돈을받고_로또티켓을_판매한다(final int moneyOfThousand) {
        //given
        final Money money = new Money(moneyOfThousand);

        //when
        final LottoShop lottoShop = new LottoShop();
        final LottoTicket lottoTicket = lottoShop.sell(money);

        //then
        assertThat(lottoTicket).isNotNull();
        assertThat(lottoTicket.get()).hasSize(money.changeUnit());
    }
}