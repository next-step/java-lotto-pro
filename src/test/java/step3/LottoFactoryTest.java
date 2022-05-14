package step3;

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
        Lotto manualLotto = LottoFactory.createManualLotto(Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        ));
        assertThat(manualLotto).isInstanceOf(Lotto.class);
    }
}
