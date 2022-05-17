package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.strategy.AutoPickNumberStrategy;

public class LottoManager {

    private Lottos lottos;

    public LottoManager(int autoLottoCount) {
        makeLottos(autoLottoCount);
    }

    public LottoManager(Lottos lottos) {
        this.lottos = lottos;
    }

    private void makeLottos(int autoLottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < autoLottoCount; i++) {
            lottoList.add(new Lotto(new AutoPickNumberStrategy()));
        }
        this.lottos = new Lottos(lottoList);
    }

    public void makeWinningLotto(Lotto winningLotto) {
        lottos.makeWinningResult(winningLotto);
    }

    public double calculateRateOfReturn(int purchaseAmount) {
        return lottos.calculateRateOfReturn(purchaseAmount);
    }

    public List<Lotto> getLottoElements() {
        return lottos.getElements();
    }

    public WinningStatistics getWinningStatistics() {
        return lottos.getWinningStatistics();
    }
}
