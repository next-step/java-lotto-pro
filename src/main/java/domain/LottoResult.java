package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Lottos lottos;
    private final WinningNumber winningNumber;
    private final Map<LottoWinning, Integer> winningResult = new HashMap<LottoWinning, Integer>() {{
        Arrays.stream(LottoWinning.values()).forEach(lottoWinning -> put(lottoWinning, 0));
    }};

    public static LottoResult of(Lottos lottos, WinningNumber winningNumber) {
        return new LottoResult(lottos, winningNumber);
    }

    private LottoResult(Lottos lottos, WinningNumber winningNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
        updateWinningResult();
    }

    public int getCountOfWinning(LottoWinning lottoWinning) {
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
        for (Lotto lotto : lottos.getLottos()) {
            LottoWinning lottoWinning = lotto.findWinning(winningNumber);
            winningResult.put(lottoWinning, winningResult.get(lottoWinning) + 1);
        }
    }
}
