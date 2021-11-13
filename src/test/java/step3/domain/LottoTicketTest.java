package step3.domain;

import static helper.Constants.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTicketTest {

    @ParameterizedTest(name = DISPLAY_NAME)
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
    void 돈을지불하면_로또티켓을_얻을_수_있다(final long moneyOfThousand) {
        //given
        final Money money = new Money(moneyOfThousand);

        //when
        final LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.publish(money);

        //then
        assertAll(
            () -> assertThat(lottoTicket).isNotNull(),
            () -> assertThat(lottoTicket.get().size()).isEqualTo(money.exchangeLottoPurchasableCount())
        );
    }
}