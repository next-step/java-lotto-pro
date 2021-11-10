package study.lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class OrderResultTest {
    @Test
    void 구매결과_잔돈을_확인_할_수_있다() {
        final OrderResult orderResult = OrderResult.valueOf(Arrays.asList(
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))
        ), TicketLotteryType.AUTO, 300);

        final Money money = orderResult.changeMoney(Money.valueOf(1000));
        assertThat(money).isEqualTo(Money.valueOf(700));
    }

    @Test
    void 기존의_로또복권_뭉치와_구매한_로또복권뭉치_와_합칠_수_있다() {
        final TicketLotteryBundle ticketLotteryBundle = TicketLotteryBundle.valueOf(Arrays.asList(
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))
        ), TicketLotteryType.AUTO);

        final OrderResult orderResult = OrderResult.valueOf(Arrays.asList(
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))
        ), TicketLotteryType.AUTO, 300);

        orderResult.merge(ticketLotteryBundle);
        assertThat(ticketLotteryBundle.size()).isEqualTo(4);
    }
}