package lotto.fixture;

import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.WinningLotto;

import java.util.Arrays;

public class WinningLottoFixture {
    public static WinningLotto winningLotto() {
        return new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new Number(7));
    }

    public static WinningLotto fiveMatchAndBonusBallMatch() {
        return new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), new Number(6));
    }

    public static WinningLotto fiveMatch() {
        return new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), new Number(8));
    }

    public static WinningLotto threeMatch() {
        return new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)), new Number(8));
    }
}
