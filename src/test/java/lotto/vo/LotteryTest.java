package lotto.vo;

import lotto.LotteryProducer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LotteryTest {
    @Test
    void 로또_번호_생성() {
        assertThatCode(() -> {
            LotteryProducer lotteryProducer = new LotteryProducer();
            List<Number> issue = lotteryProducer.issue();
            new Lottery(issue);
        }).doesNotThrowAnyException();
    }

    @Test
    void 로또_번호_생성_실패_예외() {
        assertThatThrownBy(() -> new Lottery(null)).isInstanceOf(NullPointerException.class);
    }
}