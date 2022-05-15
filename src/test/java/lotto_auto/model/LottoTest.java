package lotto_auto.model;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    void 로또_비교후_결과_랭크() {
        Lotto lotto = new Lotto(new LottoNumbers("1, 2, 3, 4, 5, 6"));
        Lotto winningLotto = new Lotto(new LottoNumbers("1, 2, 3, 4, 5, 6"));

        assertThat(lotto.matches(winningLotto)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void 로또_출력_테스트() {
        Lotto lotto = new Lotto(new LottoNumbers("1, 2, 3, 4, 5, 6"));

        assertThat(lotto.printLotto()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
