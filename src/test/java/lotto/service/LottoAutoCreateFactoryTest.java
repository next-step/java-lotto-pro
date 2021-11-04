package lotto.service;

import lotto.model.Lotto;
import lotto.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAutoCreateFactoryTest {
    private final static int LOTTO_SIZE = 6;

    @DisplayName("로또를 자동생성하는 기능 검증")
    @Test
    void lottoCreate() {
        Lotto lotto = LottoAutoCreateFactory.createLotto();
        assertThat(lotto.size()).isEqualTo(LOTTO_SIZE);
    }

    @DisplayName("숫자를 입력하면 입력한 갯수만큼 로또를 생성하는 기능 검증")
    @Test
    void createLottos() {
        Lottos lottos = LottoAutoCreateFactory.createLottos(10);
        assertThat(lottos.size()).isEqualTo(10);
    }


}
