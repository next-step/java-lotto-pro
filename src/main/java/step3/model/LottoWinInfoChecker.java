package step3.model;

import java.util.HashMap;
import java.util.Map;
import step3.enums.LottoReward;

public class LottoWinInfoChecker {

    private static final double BREAK_EVEN_POINT = 1.0;
    private static final String IS_LOSS = "손해";
    private static final String IS_BENEFIT = "이득";
    public static final String IS_BENEFIT_MAPPER = "isBenefit";
    public static final String REWARD_MAPPER = "reward";
    public static final String PROFIT_RATE_MAPPER = "profitRate";

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
        int usingMoney = ticketCount * LottoMachine.LOTTO_PRICE;
        return reward * 1.0 / usingMoney;
    }

    private String isBenefit(double profitRate) {
        if (profitRate >= LottoWinInfoChecker.BREAK_EVEN_POINT) {
            return LottoWinInfoChecker.IS_BENEFIT;
        }
        return LottoWinInfoChecker.IS_LOSS;
    }

    private long calcReward(Map<LottoReward, Integer> checkWinResult) {
        long reward = 0L;
        for (LottoReward lottoReward : checkWinResult.keySet()) {
            reward += lottoReward.getReward() * checkWinResult.get(lottoReward);
        }
        return reward;
    }
}
