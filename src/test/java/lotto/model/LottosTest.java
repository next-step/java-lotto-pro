package lotto.model;

import lotto.service.LottoAutoCreateFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("갯수를 입력받아 로또를 여러개 생성하는 기능 검증")
    @Test
    void createLottos() {
        Lottos lottos = LottoAutoCreateFactory.createLottos(20);
        assertThat(lottos.size()).isEqualTo(20);
    }

    @DisplayName("로또 당첨 상태값을 가지는 객체 검증")
    @Test
    void rankReport() {
        Lotto lotto = new Lotto(new int[]{1, 2, 3, 4, 5, 6});
        Lotto winLotto = new Lotto(new int[]{1, 2, 3, 4, 5, 6});
        Lottos lottos = new Lottos(new Lotto[]{lotto});
        List<Rank> list = lottos.matchResult(winLotto);

        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0)).isEqualTo(Rank.FIRST);

    }


}
