package lotto.domain;

import lotto.service.CreateLottoNumbersStrategy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Lottos {
    private List<Lotto> lottos = new LinkedList<>();
    private WinningResult winningResult;

    public Lottos(ManualLottos manualLottos) {
        lottos.addAll(manualLottos.getManualLottos());
    }

    public void createAutoLottos(CreateLottoNumbersStrategy createLottoNumbersStrategy, int autoLottoCount) {
        for (int i = 0; i < autoLottoCount; i++) {
            lottos.add(new Lotto(new LottoNumbers(createLottoNumbersStrategy.createLottoNumberStrings())));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<LottoPrize, Integer> getWinningResult(WinningLottoNumbers winningLottoNumbers) {
        if (winningResult != null && winningResult.isExist()){
            return winningResult.getValue();
        }
        Map<LottoPrize, Integer> lottoResultMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoPrize lottoPrize = lotto.compareWinningNumbers(winningLottoNumbers);
            int lottoWinningCount = lottoResultMap.getOrDefault(lottoPrize, 0);
            lottoResultMap.put(lottoPrize, ++lottoWinningCount);
        }
        winningResult = new WinningResult(lottoResultMap);
        return winningResult.getValue();
    }

    public double calculateProfitRate(int boughtMoney) {
        int winningMoney = winningResult.calculateWinningMoney();
        return Math.floor((((double) winningMoney / boughtMoney) * 100)) / 100.0;
    }
}
