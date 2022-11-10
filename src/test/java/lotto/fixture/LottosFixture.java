package lotto.fixture;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.Arrays;

import static lotto.fixture.LottoFixture.lotto;

public class LottosFixture {

    public static Lottos lottos() {
        Lottos lottos = new Lottos();
        lottos.add(lotto());
        return lottos;
    }

    public static Lottos point() {
        Lottos lottos = new Lottos();
        lottos.add(lotto());
        lottos.add(new Lotto(Arrays.asList(21, 22, 23, 24, 25, 26)));
        lottos.add(new Lotto(Arrays.asList(31, 32, 33, 34, 35, 36)));
        return lottos;
    }
}
