package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    void createWinningLotto() {
        assertThat(new WinningLotto(Arrays.asList(1,2,3,4,5,6))).isNotEqualTo(new WinningLotto(Arrays.asList(1,2,3,4,5,6)));
    }
}
