package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.strategy.AutoPickNumberStrategy;

public class LottoManager {

    private Lottos lottos;
    private WinningStatistics winningStatistics;

    public LottoManager(int autoLottoCount) {
        winningStatistics = new WinningStatistics();
        makeLottos(autoLottoCount);
    }

    public LottoManager(Lottos lottos) {
        winningStatistics = new WinningStatistics();
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
        lottos.makeWinningResult(winningLotto, winningStatistics);
    }

    public double calculateRateOfReturn(int purchaseAmount) {
        return winningStatistics.calculateRateOfReturn(purchaseAmount);
    }

    public List<Lotto> getLottoElements() {
        return lottos.getElements();
    }

    public WinningStatistics getWinningStatistics() {
        return winningStatistics;
    }
}
