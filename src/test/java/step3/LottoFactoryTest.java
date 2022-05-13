package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoFactoryTest {
    @Test
    void 자동_로또_생성() {
        Lotto autoLotto = LottoFactory.createAutoLotto();
        assertThat(autoLotto).isInstanceOf(Lotto.class);
    }
}
