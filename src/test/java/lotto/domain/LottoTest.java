package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("lotto equals가 의도한 대로 동작하는지 확인")
    @Test
    void lottoEqualsTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto)
                .isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))
                .isNotEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
    }

    @DisplayName("Lotto 도메인의 judge 함수가 제대로 동작하는지 확인")
    @Test
    void judgeTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoWinner first = lotto.judge(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoWinner second = lotto.judge(Arrays.asList(1, 2, 3, 4, 5, 16));
        LottoWinner third = lotto.judge(Arrays.asList(1, 2, 3, 4, 15, 16));
        LottoWinner forth = lotto.judge(Arrays.asList(1, 2, 3, 14, 15, 16));

        assertThat(first).isEqualTo(LottoWinner.FIRST);
        assertThat(second).isEqualTo(LottoWinner.SECOND);
        assertThat(third).isEqualTo(LottoWinner.THIRD);
        assertThat(forth).isEqualTo(LottoWinner.FORTH);
    }
}