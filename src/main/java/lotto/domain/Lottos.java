package lotto.domain;

import lotto.service.CreateLottoStrategy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Lottos {
    private List<Lotto> lottos = new LinkedList<>();

    public Lottos(ManualLottos manualLottos) {
        lottos.addAll(manualLottos.getManualLottos());
    }

    public void createAutoLottos(CreateLottoStrategy createLottoStrategy, int autoLottoCount) {
        for (int i = 0; i < autoLottoCount; i++) {
            lottos.add(new Lotto(new LottoNumbers(createLottoStrategy.createLottoNumberStrings())));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<LottoPrize, Integer> createLottosResult(WinningLottoNumbers winningLottoNumbers) {
        Map<LottoPrize, Integer> lottoResultMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoPrize lottoPrize = lotto.compareWinningNumbers(winningLottoNumbers);
            int lottoWinningCount = lottoResultMap.getOrDefault(lottoPrize, 0);
            lottoResultMap.put(lottoPrize, ++lottoWinningCount);
        }
        return lottoResultMap;

    }
}
