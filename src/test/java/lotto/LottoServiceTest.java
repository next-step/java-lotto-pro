package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPrize;
import lotto.service.LottoServiceCalculator;
import lotto.service.ManualLottoService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    @Test
    void 로또_개수_계산() {
        assertThat(LottoServiceCalculator.getLottoCount(14000)).isEqualTo(14);
    }

    @Test
    void 총_수익률_계산() {
        Map<LottoPrize, Integer> lottoResultMap = new HashMap<>();
        lottoResultMap.put(LottoPrize.FIFTH, 1);
        assertThat(LottoServiceCalculator.calculateProfitRate(lottoResultMap, 14000)).isEqualTo(0.35);
    }

    @Test
    void 수동로또_생성() {
        int manualLottoCount = 3;
        List<String> inputManualLottoNumbersString = Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12", "13,14,15,16,17,18");
        List<Lotto> manualLotties = ManualLottoService.createManualLotties(manualLottoCount, inputManualLottoNumbersString);
        assertThat(manualLotties).contains(new Lotto(new LottoNumbers(Arrays.asList("1", "2", "3", "4", "5", "6"))),
                                            new Lotto(new LottoNumbers(Arrays.asList("7", "8", "9", "10", "11", "12"))),
                                            new Lotto(new LottoNumbers(Arrays.asList("13", "14", "15", "16", "17", "18"))));
    }
}