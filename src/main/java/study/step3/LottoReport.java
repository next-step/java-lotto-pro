package study.step3;

import java.util.List;
import study.step3.enumtype.LottoWinningType;

public class LottoReport {
    private final List<Lotto> lottos;
    private final Lotto winningLotto;

    public LottoReport(List<Lotto> myLottos, Lotto winningLotto) {
        validate(myLottos, winningLotto);
        this.lottos = myLottos;
        this.winningLotto = winningLotto;
    }

    public LottoResultMap analyze() {
        LottoResultMap lottoResultMap = new LottoResultMap();
        lottos.forEach(lotto -> lottoResultMap.addLotto(LottoWinningType.valueOf(lotto.matchCount(winningLotto)), lotto));
        return lottoResultMap;
    }

    private void validate(List<Lotto> myLottos, Lotto winningLotto) {
        validateLottos(myLottos);
        validteWinningLotto(winningLotto);
    }


    private void validateLottos(List<Lotto> myLottos) {
        if (myLottos == null || myLottos.isEmpty()) {
            throw new IllegalArgumentException("결과를 집계할 로또과 없습니다.");
        }
    }

    private void validteWinningLotto(Lotto winningLotto) {
        if (winningLotto == null) {
            throw new IllegalArgumentException("당첨번호가 없습니다.");
        }
    }
}
