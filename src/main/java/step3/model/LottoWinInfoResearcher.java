package step3.model;

import java.util.HashMap;
import java.util.Map;
import step3.enums.LottoReward;

public class LottoWinInfoResearcher {

    private static final double BREAK_EVEN_POINT = 1.0;
    private static final int LOTTO_PRICE = 1_000;
    private static final String IS_LOSS = "손해";
    private static final String IS_BENEFIT = "이득";
    private static final String IS_BENEFIT_MAPPER = "isBenefit";
    private static final String REWARD_MAPPER = "reward";
    private static final String PROFIT_RATE_MAPPER = "profitRate";

    public Map<String, String> checkMatchLottoResult(Map<LottoReward, Integer> checkWinResult,
        int ticketCount) {
        long reward = calcReward(checkWinResult);
        double profitRate = getProfitRate(reward, ticketCount);
        String isBenefit = isBenefit(profitRate);

        Map<String, String> matchLottoResult = new HashMap<>();
        matchLottoResult.put(REWARD_MAPPER, String.valueOf(reward));
        matchLottoResult.put(PROFIT_RATE_MAPPER, String.valueOf(profitRate));
        matchLottoResult.put(IS_BENEFIT_MAPPER, isBenefit);

        return matchLottoResult;
    }

    private double getProfitRate(long reward, int ticketCount) {
        int usingMoney = ticketCount * LottoWinInfoResearcher.LOTTO_PRICE;
        return reward * 1.0 / usingMoney;
    }

    private String isBenefit(double profitRate) {
        if (profitRate >= LottoWinInfoResearcher.BREAK_EVEN_POINT) {
            return LottoWinInfoResearcher.IS_BENEFIT;
        }
        return LottoWinInfoResearcher.IS_LOSS;
    }

    private long calcReward(Map<LottoReward, Integer> checkWinResult) {
        long reward = 0L;
        for (LottoReward lottoReward : checkWinResult.keySet()) {
            reward += lottoReward.getReward() * checkWinResult.get(lottoReward);
        }
        return reward;
    }
}
