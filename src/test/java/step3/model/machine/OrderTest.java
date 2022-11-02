package step3.model.machine;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void 요청하는_티켓수가_총_티켓수보다_많으면_에러() {
        int totalCount = 5;
        int manualTicket = 10;
        assertThatThrownBy(() -> new Order(totalCount,manualTicket))
                .isInstanceOf(IllegalArgumentException.class);
    }
}