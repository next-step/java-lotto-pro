package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoBundleTest {

    private final List<Lotto> lottoList;

    public LottoBundleTest() {
        lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 44, 45)),
                new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45)),
                new Lotto(Arrays.asList(1, 2, 42, 43, 44, 45)),
                new Lotto(Arrays.asList(1, 41, 42, 43, 44, 45))
        );
    }

    @Test
    void countWinning() {
        LottoBundle lottoBundle = new LottoBundle(lottoList);

        WinningMoney winningMoney = lottoBundle.countWinning(new WinningLotto(Arrays.asList(10, 11, 12, 13, 14, 15),16));

        assertThat(winningMoney).isEqualTo(new WinningMoney(Collections.EMPTY_LIST));
    }

    @Test
    void countWinning2() {
        LottoBundle lottoBundle = new LottoBundle(lottoList);

        WinningMoney winningMoney = lottoBundle.countWinning(new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6),16));

        assertThat(winningMoney).isEqualTo(new WinningMoney(Arrays.asList(FIRST, THIRD, FOURTH, FIFTH)));
    }
}