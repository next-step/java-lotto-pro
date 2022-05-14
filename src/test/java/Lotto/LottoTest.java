package Lotto;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 로또_1과45사이_6개의_숫자_추출() {
        Lotto lotto = new Lotto();
        assertThat(Collections.max(lotto.getNumbers())).isBetween(1, 45);
        assertThat(Collections.min(lotto.getNumbers())).isBetween(1, 45);
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }
}
