package study.lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketLotteryTest {
    @Test
    void 로또복권의_타입을_받아_생성할_수_있다() {

        assertEquals(TicketLottery.valueOf(Arrays.asList(1, 2, 3, 4, 5, 6), TicketLotteryType.AUTO), TicketLottery.valueOf(Arrays.asList(1, 2, 3, 4, 5, 6), TicketLotteryType.AUTO));

    }
}
