package lotto.fixture;

import lotto.domain.Lottos;

public class LottosFixture {
    public static Lottos lottos() {
        Lottos lottos = new Lottos();
        lottos.add(LottoFixture.로또번호123456());
        return lottos;
    }
}
