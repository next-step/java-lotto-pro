package study.step3.domain.lotto;

import study.step3.domain.lottonumber.LottoNumbers;

import java.util.List;

public class LottoMachine {

    public Lottos issueRandomLottos(long count) {
        LottoIssuance lottoIssuance = LottoIssuance.ofCount(count);
        return issueLottos(lottoIssuance);
    }

    public Lottos issueManualLottos(List<LottoNumbers> lottoNumbersGroup) {
        LottoIssuance lottoIssuance = LottoIssuance.ofLottoNumbersGroup(lottoNumbersGroup);
        return issueLottos(lottoIssuance);
    }

    private Lottos issueLottos(LottoIssuance lottoIssuance) {
        LottoIssuanceStrategy lottoIssuanceStrategy = LottoIssuanceStrategyFactory.of(lottoIssuance);
        return lottoIssuanceStrategy.issueLottos(lottoIssuance);
    }
}
