package study.lotto;

import java.util.List;

public class LottoReport {
    private final List<Lotto> lottos;
    private final WinningLotto winningLotto;

    public LottoReport(List<Lotto> myLottos, WinningLotto winningLotto) {
        validate(myLottos, winningLotto);
        this.lottos = myLottos;
        this.winningLotto = winningLotto;
    }

    public LottoResultMap analyze() {
        LottoResultMap lottoResultMap = new LottoResultMap();
        lottos.forEach(
                lotto -> lottoResultMap.addLotto(winningLotto.matchLotto(lotto), lotto));
        return lottoResultMap;
    }

    private void validate(List<Lotto> myLottos, WinningLotto winningLotto) {
        validateLottos(myLottos);
        validteWinningLotto(winningLotto);
    }


    private void validateLottos(List<Lotto> myLottos) {
        if (myLottos == null || myLottos.isEmpty()) {
            throw new IllegalArgumentException("결과를 집계할 로또과 없습니다.");
        }
    }

    private void validteWinningLotto(WinningLotto winningLotto) {
        if (winningLotto == null) {
            throw new IllegalArgumentException("당첨번호가 없습니다.");
        }
    }
}
