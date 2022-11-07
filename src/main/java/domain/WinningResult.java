package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WinningResult {
    private final Map<LottoWinning, Integer> winningResult = new HashMap<LottoWinning, Integer>() {{
        Arrays.stream(LottoWinning.values()).forEach(lottoWinning -> put(lottoWinning, 0));
    }};

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
