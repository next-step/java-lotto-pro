package lotto.model;

import lotto.view.ResultView;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Map;

public class Result {
    private Map<Rank,Integer> matchResult;

    public Result(Map<Rank,Integer> matchResult) {
        if(matchResult.containsKey(Rank.MISS)){
            matchResult.remove(Rank.MISS);
        }
        this.matchResult = matchResult;
    }

    public Map<Rank, Integer> getMatchResult() {
        return Collections.unmodifiableMap(matchResult);
    }

    public String yield(BigInteger purchase) {
        BigInteger lottoRevenueAmount = makeRevenueAmount();
        double lottoYield = lottoRevenueAmount.doubleValue() / purchase.doubleValue();
        return String.format("%.2f",lottoYield);
    }

    private BigInteger makeRevenueAmount() {
        BigInteger amount = BigInteger.ZERO;
        matchResult.forEach((rank, count) -> {
            BigInteger rankAmount = new BigInteger(String.valueOf(rank.getWinningMoney()));
            rankAmount.multiply(new BigInteger(String.valueOf(count)));
            amount.add(rankAmount);
        });
        return amount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        matchResult.forEach((rank, count) -> {
            sb.append(String.format(ResultView.STATS, rank.getCountOfMatch(), rank.getWinningMoney(), count));
        });
        return sb.toString();
    }
}
