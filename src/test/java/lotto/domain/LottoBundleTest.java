package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.domain.WinningBonus.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoBundleTest {

    private final List<Lotto> lottos;

    public LottoBundleTest() {
        lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 44, 45)),
                new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45)),
                new Lotto(Arrays.asList(1, 2, 42, 43, 44, 45)),
                new Lotto(Arrays.asList(1, 41, 42, 43, 44, 45))
        );
    }

    @Test
    void test1() {
        LottoBundle lottoBundle = new LottoBundle(lottos);

        assertThat(lottoBundle.toString()).matches("\\[[0-9,]+]");
    }

    @Test
    @DisplayName("정답 번호를 넘기면 등수별 갯수를 가지고 있는 winningMoney 를 반환함")
    void test2() {
        LottoBundle lottoBundle = new LottoBundle(lottos);

        WinningMoney winningMoney = lottoBundle.countWinning(new Lotto(Arrays.asList(1,2,3,4,5,6)));

        assertThat(winningMoney.count(THREE)).isEqualTo(1);
        assertThat(winningMoney.count(FOUR)).isEqualTo(1);
        assertThat(winningMoney.count(FIVE)).isEqualTo(1);
        assertThat(winningMoney.count(SIX)).isEqualTo(1);
    }
}