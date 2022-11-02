package step3.model;

import step3.model.dto.LottoResultDto;
import step3.model.dto.LottoStatusDto;

import java.util.Map;

public class LottoMachine {

    private final Lottos lottos;
    private final LottoMoney lottoMoney;

    public LottoMachine(LottoMoney lottoMoney, Lottos lottos) {
        this.lottoMoney = lottoMoney;
        this.lottos = lottos;
    }

    public LottoResultDto getLottoResult(Lotto lotto) {
        Map<Rank, Integer> rankOfLottos = lottos.getRankOfLottos(lotto);
        return new LottoResultDto(rankOfLottos, lottoMoney);
    }

    public LottoResultDto getLottoResult(WinningLotto winningLotto) {
        Map<Rank, Integer> rankOfLottos = lottos.getRankOfLottos(winningLotto);
        return new LottoResultDto(rankOfLottos, lottoMoney);
    }

    public LottoStatusDto getLottoStatus() {
        return new LottoStatusDto(lottos, lottoMoney);
    }

}
