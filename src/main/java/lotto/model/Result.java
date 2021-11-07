package lotto.model;

import lotto.util.ConstantString;
import lotto.view.Message;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private Map<Rank, Integer> matchResult;

    public Result(Lottos lottos, Lotto winLotto) {
        this.matchResult = createResultMap();
        for (int i = 0; i < lottos.size(); i++) {

            Rank rank = winLotto.matchNumber(lottos.getLottoGroup().get(i));
            matchResultPut(rank);
        }
    }

    private void matchResultPut(Rank rank) {
        if(rank != null && rank != Rank.MISS){
            matchResult.put(rank, matchResult.get(rank) + 1);
        }
    }

    private Map<Rank, Integer> createResultMap() {
        Map<Rank, Integer> result = new LinkedHashMap<>();
        List<Rank> winningRanks = Rank.createWinningRanks();
        for (Rank winningRank : winningRanks) {
            result.put(winningRank, 0);
        }

        return result;
    }

    public String yield(BigInteger purchase) {
        BigInteger lottoRevenueAmount = makeRevenueAmount();
        double lottoYield = lottoRevenueAmount.doubleValue() / purchase.doubleValue();
        return String.format(ConstantString.SECOND_DECIMAL_PLACE, lottoYield);
    }

    public BigInteger makeRevenueAmount() {
        BigInteger amount = BigInteger.ZERO;
        for (Rank rank : matchResult.keySet()) {
            BigInteger rankAmount = new BigInteger(String.valueOf(rank.getWinningMoney()));
            rankAmount = rankAmount.multiply(new BigInteger(String.valueOf(matchResult.get(rank))));
            amount = amount.add(rankAmount);
        }
        return amount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        matchResult.forEach((rank, count) -> {
            sb.append(String.format(Message.STATS, rank.getCountOfMatch(), rank.getWinningMoney(), count));
        });
        return sb.toString();
    }
}
