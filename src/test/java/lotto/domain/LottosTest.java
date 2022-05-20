package lotto.domain;

import lotto.service.LottoAutoIssuedServiceImpl;
import lotto.service.LottoIssuedService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private LottoIssuedService lottoIssuedService;
    @BeforeEach
    public void setUp() {
        lottoIssuedService = new LottoAutoIssuedServiceImpl();
    }

    @Test
    @DisplayName("발급된 로또 갯수를 확인한다.")
    void 발급된_로또_갯수_확인() {
        Lottos lottos = new Lottos(lottoIssuedService, 100);
        assertThat(lottos.getLottos().size()).isEqualTo(100);
    }

    @Test
    @DisplayName("보너스볼이 일치하는지 확인한다.")
    void 보너스볼_일치_확인() {
        Lottos lottos = new Lottos(lottoIssuedService, 1);
        Lotto answerLotto = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lottos.checkCorrectBonusBall()).isFalse();
    }
}
