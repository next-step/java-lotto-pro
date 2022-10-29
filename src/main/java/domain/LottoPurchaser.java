package domain;

import static domain.LottoWinning.FIRST_PRIZE;
import static domain.LottoWinning.FOURTH_PRIZE;
import static domain.LottoWinning.NONE;
import static domain.LottoWinning.SECOND_PRIZE;
import static domain.LottoWinning.THIRD_PRIZE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoPurchaser {
    private final List<Lotto> lottos;
    private final List<Integer> winningNumber;
    private final Map<LottoWinning, Integer> winningResult = new HashMap<LottoWinning, Integer>() {{
        put(FIRST_PRIZE, 0);
        put(SECOND_PRIZE, 0);
        put(THIRD_PRIZE, 0);
        put(FOURTH_PRIZE, 0);
        put(NONE, 0);
    }};

    public static LottoPurchaser of(List<Lotto> lottos, List<Integer> winningNumbers) {
        return new LottoPurchaser(lottos, winningNumbers);
    }

    private LottoPurchaser(List<Lotto> lottos, List<Integer> winningNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
        updateWinningResult();
    }

    public int findWinning(LottoWinning lottoWinning) {
        return winningResult.get(lottoWinning);
    }

    public float earningRate() {
        return getTotalPrize() / getSpentMoney();
    }

    private float getTotalPrize() {
        return Arrays.stream(LottoWinning.values())
            .map(l -> winningResult.get(l) * l.getPrize())
            .reduce(0f, Float::sum);
    }

    private float getSpentMoney() {
        return lottos.size() * Lotto.SELL_PRICE;
    }

    private void updateWinningResult() {
        for (Lotto lotto : lottos) {
            LottoWinning lottoWinning = lotto.findWinning(winningNumber);
            winningResult.put(lottoWinning, winningResult.get(lottoWinning) + 1);
        }
    }
}
