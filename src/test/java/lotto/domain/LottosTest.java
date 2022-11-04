package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("로또리스트로 구성되어있는 로또들 생성 테스트")
    @Test
    void 로또들_생성() {
        List<Lotto> lottoList = new ArrayList<>();
        LottoCreateStrategy strategy = new AutoLottoCreateStrategy();
        lottoList.add(strategy.createLotto());
        lottoList.add(strategy.createLotto());
        lottoList.add(strategy.createLotto());
        lottoList.add(strategy.createLotto());
        lottoList.add(strategy.createLotto());

        Lottos lottos = new Lottos(lottoList);

        assertThat(lottos).isInstanceOf(Lottos.class);
    }
}
