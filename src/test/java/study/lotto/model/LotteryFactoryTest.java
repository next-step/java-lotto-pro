package study.lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class LotteryFactoryTest {
    @Test
    void 로또생성기_를_통해서_로또복권_을_생성할_수_있다() {
        final TicketLottery ticketLottery = LotteryFactory.generateAutoTicketLottery();
        assertThat(ticketLottery).isNotNull();
    }

    @Test
    void 주문수량에_따라_로또생성을_할_수_있다() {
        assertThatNoException()
                .isThrownBy(() -> LotteryFactory.generateAutoTicketLotteryBundleByCount(TicketOrderCount.valueOf(3)));
    }

}
