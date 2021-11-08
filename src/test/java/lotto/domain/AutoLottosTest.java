package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class AutoLottosTest {

    @Test
    void 자동_로또들을_생성한다() {
        AutoLottos autoLottos = new AutoLottos(2, new FakeNumbers());
        List<Lotto> expected = autoLottos.getAutoLottos();
        assertAll(
                () -> assertThat(expected.size()).isEqualTo(2),
                () -> assertThat(expected.get(0)).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))),
                () -> assertThat(expected.get(1)).isEqualTo(new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)))
        );
    }
}