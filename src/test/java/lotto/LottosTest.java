package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(lottos.getLottos()).contains(new Lotto(new LottoNumbers(Arrays.asList("1", "2", "3", "4", "5", "6"))),
                                                            new Lotto(new LottoNumbers(Arrays.asList("3", "4", "5", "6", "7", "8"))));
    }

    @Test
    void 당첨_통계() {
        lottos.createAutoLottos(() -> Arrays.asList("3", "4", "5", "6", "7", "8"), 1);
        Map<LottoPrize, Integer> result =  lottos.createLottosResult(
                                        new WinningLottoNumbers(Arrays.asList("1", "2", "3", "4", "5", "6"), new BonusNumber("7")));
        assertThat(result).containsKeys(LottoPrize.FIRST, LottoPrize.FOURTH);
    }

}
