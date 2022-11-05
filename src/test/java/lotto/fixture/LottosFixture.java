package lotto.fixture;

import lotto.domain.Lottos;

import static lotto.fixture.LottoFixture.lotto;

public class LottosFixture {
    public static Lottos lottos() {
        Lottos lottos = new Lottos();
        lottos.add(lotto());
        return lottos;
    }
}
