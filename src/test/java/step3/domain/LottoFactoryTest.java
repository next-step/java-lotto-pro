package step3.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {
    @Test
    void 자동_로또_생성() {
        Lotto autoLotto = LottoFactory.createAutoLotto();
        assertThat(autoLotto).isInstanceOf(Lotto.class);
    }

    @Test
    void 수동_로또_생성() {
        Lotto manualLotto = LottoFactory.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(manualLotto).isInstanceOf(Lotto.class);
    }
}
