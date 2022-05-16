package lotto.vo;

import lotto.LotteryUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LotteryTest {
    @Test
    void 로또_번호_생성() {
        assertThatCode(() -> {
            LotteryUtils lotteryUtils = new LotteryUtils(1, 45);
            new Lottery(lotteryUtils.pickRandomNumbers(6));
        }).doesNotThrowAnyException();
    }

    @Test
    void 로또_번호_생성_실패_예외() {
        assertThatThrownBy(() -> new Lottery(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void 로또_번호_생성_개수_예외() {
        assertThatThrownBy(() -> {
            LotteryUtils lotteryUtils = new LotteryUtils(1, 45);
            new Lottery(lotteryUtils.pickRandomNumbers(3));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_생성_범위_예외() {
        assertThatThrownBy(() -> {
            LotteryUtils lotteryUtils = new LotteryUtils(-45, 45);
            new Lottery(lotteryUtils.pickRandomNumbers(6));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}