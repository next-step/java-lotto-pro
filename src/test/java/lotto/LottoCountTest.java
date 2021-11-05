package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoCountTest {

    @Test
    void name() {
        LottoCount lottoCount = new LottoCount(2);
        assertThat(lottoCount).isEqualTo(new LottoCount(2));
    }
}
