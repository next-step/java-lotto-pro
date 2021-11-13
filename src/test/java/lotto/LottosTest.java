package lotto;

import lotto.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LottosTest {
    Lottos lottos;

    @BeforeEach
    void init() {
        ManualLottos manualLottos = new ManualLottos(new ManualLottosCount(2, 1));
        manualLottos.createManualLottos(Arrays.asList("1,2,3,4,5,6"));
        lottos = new Lottos(manualLottos);
    }

    @Test
    void 자동로또_생성() {
        lottos.createAutoLottos(() -> Arrays.asList("3", "4", "5", "6", "7", "8"), 1);
        Assertions.assertThat(lottos.getLottos()).contains(new Lotto(new LottoNumbers(Arrays.asList("1", "2", "3", "4", "5", "6"))),
                                                            new Lotto(new LottoNumbers(Arrays.asList("3", "4", "5", "6", "7", "8"))));
    }

}
