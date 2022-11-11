package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    private final Map<LottoWinning, Integer> winningResult = new HashMap<LottoWinning, Integer>() {{
        Arrays.stream(LottoWinning.values()).forEach(lottoWinning -> put(lottoWinning, 0));
    }};

    public static WinningResult of(List<Lotto> lottos, WinningNumber winningNumber) {
        WinningResult winningResult = new WinningResult();
        for (Lotto lotto : lottos) {
            LottoWinning lottoWinning = lotto.findWinning(winningNumber);
            winningResult.increment(lottoWinning);
        }
        return winningResult;
    }

    public static WinningResult merge(WinningResult selfPickWinningResult, WinningResult quickPickWinningResult) {
        WinningResult result = new WinningResult();
        selfPickWinningResult.winningResult.forEach((lottoWinning, count) -> {
            result.winningResult.put(lottoWinning, result.winningResult.get(lottoWinning) + count);
        });
        quickPickWinningResult.winningResult.forEach((lottoWinning, count) -> {
            result.winningResult.put(lottoWinning, result.winningResult.get(lottoWinning) + count);
        });
        return result;
    }

    public void increment(LottoWinning lottoWinning) {
        winningResult.put(lottoWinning, winningResult.get(lottoWinning) + 1);
    }

    public int totalPrize() {
        return Arrays.stream(LottoWinning.values())
                .map(l -> winningResult.get(l) * l.getPrize())
                .reduce(0, Integer::sum);
    }

    public int countOfMatch(LottoWinning lottoWinning) {
        return winningResult.get(lottoWinning);
    }
}
