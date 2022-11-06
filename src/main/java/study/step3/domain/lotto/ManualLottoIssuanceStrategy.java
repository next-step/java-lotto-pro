package study.step3.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoIssuanceStrategy implements LottoIssuanceStrategy {

    @Override
    public boolean isIssuableLottos(LottoIssuance lottoIssuance) {
        return lottoIssuance.isManualLottos();
    }

    @Override
    public Lottos issueLottos(LottoIssuance lottoIssuance) {
        List<Lotto> lottos = lottoIssuance.lottoNumbersGroup().stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }
}
