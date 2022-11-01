package step3.model;

import step3.model.dto.LottoResultDto;
import step3.model.dto.LottosNumberDto;

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
        return getLottoResultDto(rankOfLottos);
    }

    public LottoResultDto getLottoResult(WinningLotto winningLotto) {
        Map<Rank, Integer> rankOfLottos = lottos.getRankOfLottos(winningLotto);
        return getLottoResultDto(rankOfLottos);
    }

    private LottoResultDto getLottoResultDto(Map<Rank, Integer> rankOfLottos) {
        return new LottoResultDto(rankOfLottos, lottoMoney);
    }

    public LottosNumberDto getLottoNumber() {
        return new LottosNumberDto(lottos,lottoMoney);
    }
}
