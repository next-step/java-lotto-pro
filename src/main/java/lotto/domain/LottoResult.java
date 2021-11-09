package lotto.domain;

import lotto.exception.LottoException;
import lotto.utils.NumberUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private static final String LOTTO_LIST_CAN_NOT_BE_EMPTY = "로또 리스트는 1개 이상이어야 합니다.";
    private static final int EARNING_RATE_DECIMAL_PLACE = 3;

    private final Map<Integer, Integer> result = new HashMap<>();

    public LottoResult(Lotto winningLotto, List<Lotto> lottoList) {
        if (lottoList.isEmpty()) {
            throw new LottoException(LOTTO_LIST_CAN_NOT_BE_EMPTY);
        }
        for (Lotto lotto : lottoList) {
            int matchCount = winningLotto.match(lotto);
            result.put(matchCount, result.getOrDefault(matchCount, 0) + 1);
        }
    }

    public int getResult(int key) {
        return result.getOrDefault(key, 0);
    }

    public double getEarningsRate() {
        int purchaseAmount = getPurchaseAmount();
        double earningsRate = getEarningsRate(purchaseAmount);
        return NumberUtils.roundDown(earningsRate, EARNING_RATE_DECIMAL_PLACE);
    }

    private double getEarningsRate(int purchaseAmount) {
        double winningAmount = 0;
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            int prizeMoney = LottoPrize.valueOf(entry.getKey()).getPrizeMoney();
            Integer placeCount = entry.getValue();
            winningAmount += (prizeMoney * placeCount);
        }
        return winningAmount / purchaseAmount;
    }

    private int getPurchaseAmount() {
        int lottoCount = result.values().stream()
                .reduce(Integer::sum)
                .orElseThrow(() -> new LottoException(LOTTO_LIST_CAN_NOT_BE_EMPTY));
        return Lotto.PRICE * lottoCount;
    }
}
