package study.step3.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoIssuanceStrategyFactory {

    private final static List<LottoIssuanceStrategy> lottoIssuanceStrategies;

    static {
        lottoIssuanceStrategies = new ArrayList<>();
        lottoIssuanceStrategies.add(new ManualLottoIssuanceStrategy());
        lottoIssuanceStrategies.add(new RandomLottoIssuanceStrategy());
    }

    public static LottoIssuanceStrategy of(LottoIssuance lottoIssuance) {
        return lottoIssuanceStrategies.stream()
                .filter(lottoIssuanceStrategy -> lottoIssuanceStrategy.isIssuableLottos(lottoIssuance))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
