package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.WinningLotto;
import lotto.strategy.AutoPickNumberStrategy;

public class LottoManager {

    private WinningStatistics winningStatistics;

    public LottoManager() {
        winningStatistics = new WinningStatistics();
    }

    public Lottos makeLottos(int autoLottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < autoLottoCount; i++) {
            lottoList.add(new Lotto(new AutoPickNumberStrategy()));
        }
        return new Lottos(lottoList);
    }

    public void makeWinningLotto(WinningLotto winningLotto, Lottos lottos) {
        for (Lotto lotto : lottos.getElements()) {
            winningStatistics.addLottoRanking(LottoRanking.findLottoRaking(lotto, winningLotto));
        }
    }

    public double calculateRateOfReturn(int purchaseAmount) {
        return winningStatistics.calculateRateOfReturn(purchaseAmount);
    }

    public WinningStatistics getWinningStatistics() {
        return winningStatistics;
    }
}