package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final List<Lotto> lottos;
    private final List<Integer> winningNumbers;
    private final Map<LottoWinning, Integer> winningResult = new HashMap<LottoWinning, Integer>() {{
        Arrays.stream(LottoWinning.values()).forEach(lottoWinning -> put(lottoWinning, 0));
    }};

    public static LottoResult of(List<Lotto> lottos, List<Integer> winningNumbers) {
        return new LottoResult(lottos, winningNumbers);
    }

    private LottoResult(List<Lotto> lottos, List<Integer> winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        updateWinningResult();
    }

    public int findWinning(LottoWinning lottoWinning) {
        return winningResult.get(lottoWinning);
    }

    public float getEarningRate() {
        return getTotalPrize() / getSpentMoney();
    }

    private int getTotalPrize() {
        return Arrays.stream(LottoWinning.values())
            .map(l -> winningResult.get(l) * l.getPrize())
            .reduce(0, Integer::sum);
    }

    private float getSpentMoney() {
        return lottos.size() * Lotto.SELL_PRICE;
    }

    private void updateWinningResult() {
        for (Lotto lotto : lottos) {
            LottoWinning lottoWinning = lotto.findWinning(winningNumbers);
            winningResult.put(lottoWinning, winningResult.get(lottoWinning) + 1);
        }
    }
}
