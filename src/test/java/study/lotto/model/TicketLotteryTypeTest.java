package study.lotto.model;

import org.junit.jupiter.api.Test;
import study.lotto.model.exception.TicketLotteryTypeNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class TicketLotteryTypeTest {

    @Test
    void 로또복권의_타입이_자동인지_확인할_수있다() {
        assertAll(() -> {
            assertTrue(TicketLotteryType.AUTO.isAutoTicket());
            assertFalse(TicketLotteryType.MANUAL.isAutoTicket());
        });
    }


    @Test
    void 로또복권의_타입이_수동인지_확인할_수있다() {
        assertAll(() -> {
            assertTrue(TicketLotteryType.MANUAL.isManualTicket());
            assertFalse(TicketLotteryType.AUTO.isManualTicket());
        });
    }

    @Test
    void 문자열_타입을_통해서_로또복권의_타입을_찾을_수_있다() {
        assertAll(() -> {
            assertSame(TicketLotteryType.findByType("AUTO"), TicketLotteryType.AUTO);
            assertSame(TicketLotteryType.findByType("MANUAL"), TicketLotteryType.MANUAL);
        });
    }

    @Test
    void 문자열_타입을_통해서_로또복권의_타입을_찾지_못_한경우_예외가_발생한다() {
        assertAll(() -> {
            assertThrows(TicketLotteryTypeNotFoundException.class, () -> TicketLotteryType.findByType("efefsdfadf"));
            assertThrows(TicketLotteryTypeNotFoundException.class, () -> TicketLotteryType.findByType(""));
            assertThrows(TicketLotteryTypeNotFoundException.class, () -> TicketLotteryType.findByType(null));
        });
    }
}