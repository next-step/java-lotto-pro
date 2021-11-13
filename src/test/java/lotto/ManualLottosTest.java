package lotto;

import lotto.domain.ManualLottosCount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ManualLottosTest {
    @Test
    void 수동로또_개수_유효검사() {
        int totalLottoCount = 3;
        int manualLottoCount = 5;
        assertThatThrownBy(() ->
                new ManualLottosCount(totalLottoCount, manualLottoCount)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수동로또_개수_0미만_오류() {
        int totalLottoCount = 3;
        int manualLottoCount = -1;
        assertThatThrownBy(() ->
                new ManualLottosCount(totalLottoCount, manualLottoCount)).isInstanceOf(IllegalArgumentException.class);
    }
}
