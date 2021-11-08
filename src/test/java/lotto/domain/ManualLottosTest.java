package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottosTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "10,11,12,13,14,15"})
    void 수동_로또들을_생성한다(String numbers1, String numbers2) {
        ManualLottos manualLottos = new ManualLottos(Arrays.asList(numbers1, numbers2));
        assertThat(manualLottos.getManualLottos())
                .contains(new Lotto(numbers1), new Lotto(numbers2));
    }
}