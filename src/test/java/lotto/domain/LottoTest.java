package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 로또를_생성한다() {
        assertThat(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
