package lotto.fixture;

import lotto.domain.Lottos;

import static lotto.fixture.LottoFixture.*;

public class LottosFixture {
    public static Lottos lottos() {
        Lottos lottos = new Lottos();
        lottos.add(로또번호123456());
        return lottos;
    }
}
