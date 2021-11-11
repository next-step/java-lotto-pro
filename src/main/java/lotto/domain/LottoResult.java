package lotto.domain;

import lotto.exception.LottoException;
import lotto.utils.NumberUtils;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private static final String LOTTO_LIST_CAN_NOT_BE_EMPTY = "로또 리스트는 1개 이상이어야 합니다.";
    private static final int EARNING_RATE_DECIMAL_PLACE = 3;

    private final Map<LottoPrize, Integer> result = new EnumMap<>(LottoPrize.class);

    public LottoResult(WinningLotto winningLotto, List<Lotto> lottoList) {
        if (lottoList.isEmpty()) {
            throw new LottoException(LOTTO_LIST_CAN_NOT_BE_EMPTY);
        }
        for (Lotto lotto : lottoList) {
            int matchCount = winningLotto.getMatchCount(lotto);
            boolean matchBonus = winningLotto.checkMatchBonus(lotto);

            LottoPrize lottoPrize = LottoPrize.valueOf(matchCount, matchBonus);
            result.put(lottoPrize, result.getOrDefault(lottoPrize, 0) + 1);
        }
    }

    public int getPrizeCount(LottoPrize lottoPrize) {
        return result.getOrDefault(lottoPrize, 0);
    }

    public double getEarningsRate() {
        int purchaseAmount = getPurchaseAmount();
        double earningsRate = getEarningsRate(purchaseAmount);
        return NumberUtils.roundDown(earningsRate, EARNING_RATE_DECIMAL_PLACE);
    }

    private double getEarningsRate(int purchaseAmount) {
        double winningAmount = 0;
        for (Map.Entry<LottoPrize, Integer> entry : result.entrySet()) {
            int prizeMoney = getPrizeMoney(entry);
            int placeCount = entry.getValue();
            winningAmount += (prizeMoney * placeCount);
        }
        return winningAmount / purchaseAmount;
    }

    private int getPrizeMoney(Map.Entry<LottoPrize, Integer> entry) {
        if (entry.getKey() == LottoPrize.SECOND_PLACE) {
            return LottoPrize.valueOf(entry.getKey().getMatchCount(), true).getPrizeMoney();
        }
        return LottoPrize.valueOf(entry.getKey().getMatchCount(), false).getPrizeMoney();
    }

    private int getPurchaseAmount() {
        int lottoCount = result.values().stream()
                .reduce(Integer::sum)
                .orElseThrow(() -> new LottoException(LOTTO_LIST_CAN_NOT_BE_EMPTY));
        return Lotto.PRICE * lottoCount;
    }
}
