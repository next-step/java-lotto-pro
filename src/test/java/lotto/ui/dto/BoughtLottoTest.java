package lotto.ui.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class BoughtLottoTest {
    @Test
    void 문자열_변환() {
        final BoughtLotto lotto = new BoughtLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
