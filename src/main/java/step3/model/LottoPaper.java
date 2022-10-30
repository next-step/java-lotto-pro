package step3.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoPaper {
    private List<Lotto> lottos;

    public LottoPaper(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public WinningReport checkWinning(WinningLotto winningLotto) {
        Map<Award, Integer> resultMap = new HashMap<>();
        int totalWinningAmount = 0;
        for (Lotto lotto : lottos) {
            Award award = lotto.match(winningLotto);
            totalWinningAmount += award.winningMoney();
            resultMap.put(award, resultMap.getOrDefault(award, 0) + 1);
        }
        return new WinningReport(resultMap,
            Math.floor(((double) totalWinningAmount / ((double) lottos.size() * 1000)) * 100) / 100);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
