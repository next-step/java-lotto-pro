package study.lotto.model;

import org.junit.jupiter.api.Test;
import study.lotto.model.exception.IllegalTicketOrderCountException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertAll;

class TicketOrderCountTest {
    @Test
    void 주문수량1개이상으로_로또복권주문수량_을_생성할_수_있다() {
        assertAll(() -> {
            assertThatNoException()
                    .isThrownBy(() -> TicketOrderCount.valueOf(1));
            assertThatNoException()
                    .isThrownBy(() -> TicketOrderCount.valueOf(100));
            assertThatNoException()
                    .isThrownBy(() -> TicketOrderCount.valueOf(2000));
        });
    }

    @Test
    void 주문수량1개미만으로_로또복권주문수량_을_생성할_경우_예외가_발생한다() {
        assertAll(() -> {
            assertThatExceptionOfType(IllegalTicketOrderCountException.class)
                    .isThrownBy(() -> TicketOrderCount.valueOf(-1))
                    .withMessageMatching("최소 1개의 주문갯수가 필요합니다.");
            assertThatExceptionOfType(IllegalTicketOrderCountException.class)
                    .isThrownBy(() -> TicketOrderCount.valueOf(0))
                    .withMessageMatching("최소 1개의 주문갯수가 필요합니다.");
            assertThatExceptionOfType(IllegalTicketOrderCountException.class)
                    .isThrownBy(() -> TicketOrderCount.valueOf(-2000))
                    .withMessageMatching("최소 1개의 주문갯수가 필요합니다.");

        });
    }

}