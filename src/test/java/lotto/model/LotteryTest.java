package lotto.model;

import lotto.model.Lottery;
import lotto.service.LotteryProducer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LotteryTest {
    @Test
    void 로또_번호_생성() {
        assertThatCode(() -> new Lottery(LotteryProducer.issue())).doesNotThrowAnyException();
    }

    @Test
    void 로또_번호_생성_실패_예외() {
        assertThatThrownBy(() -> new Lottery(null)).isInstanceOf(NullPointerException.class);
    }
}