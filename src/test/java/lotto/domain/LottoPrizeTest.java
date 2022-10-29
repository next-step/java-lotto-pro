package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class LottoPrizeTest {

    @Test
    void 로또_번호가_5개_동일하면_2등() {
        assertThat(LottoPrize.findLottoPrize(5)).isEqualTo(LottoPrize.SECOND);
    }

    @Test
    void 로또_번호가_2개_이하로_동일하면_NO_PRIZE() {
        assertAll(
                () -> assertThat(LottoPrize.findLottoPrize(2)).isEqualTo(LottoPrize.NO_PRIZE),
                () -> assertThat(LottoPrize.findLottoPrize(1)).isEqualTo(LottoPrize.NO_PRIZE),
                () -> assertThat(LottoPrize.findLottoPrize(0)).isEqualTo(LottoPrize.NO_PRIZE)
        );
    }

    @Test
    void isNoPrize의_매개변수가_NO_PRIZE_이면_isNoPrize는_진실() {
        assertThat(LottoPrize.isNoPrize(LottoPrize.NO_PRIZE)).isTrue();
    }

    @Test
    void isNoPrize의_매개변수가_NO_PRIZE가_아니면_isNoPrize는_진실() {
        assertThat(LottoPrize.isNoPrize(LottoPrize.SECOND)).isFalse();
    }
}
