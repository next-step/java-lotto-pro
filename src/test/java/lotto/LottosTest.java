package lotto;

import lotto.domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottosTest {
    @Test
    void 수동로또_개수_유효검사() {
        int totalLottoCount = 3;
        int manualLottoCount = 5;
        Assertions.assertThatThrownBy(() ->
                new Lottos(totalLottoCount, manualLottoCount)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수동로또_개수_0미만_오류() {
        int totalLottoCount = 3;
        int manualLottoCount = -1;
        Assertions.assertThatThrownBy(() ->
                new Lottos(totalLottoCount, manualLottoCount)).isInstanceOf(IllegalArgumentException.class);
    }
}
