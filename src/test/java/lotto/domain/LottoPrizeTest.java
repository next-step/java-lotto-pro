package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoPrizeTest {

    @Test
    void 로또_번호가_5개_동일하면_2등() {
        assertThat(LottoPrize.findLottoPrize(5)).isEqualTo(LottoPrize.SECOND);
    }
}
