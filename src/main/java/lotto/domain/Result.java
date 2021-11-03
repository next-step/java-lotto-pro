package lotto.domain;

import java.util.EnumMap;

public class Result {

    private static final int LOTTO_PRICE = 1_000;

    private final EnumMap<Rank, Integer> result;

    private Result(EnumMap<Rank, Integer> result) {
        this.result = result;
    }

    public static Result from(final Lotto winningLotto, final Lottos lottos)  {
        EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        lottos.findRank(result, winningLotto);

        return new Result(result);
    }

    public double calculatePrizeMoney() {
        int totalPrize = 0;
        int lottoCount = 0;

        for (Rank rank : result.keySet()) {
            totalPrize += rank.totalWinningMoney(result.get(rank));
            lottoCount += result.get(rank);
        }

        return (double) totalPrize / (lottoCount * LOTTO_PRICE);
    }

    public EnumMap<Rank, Integer> getResult() {
        return this.result;
    }

    public int getRankHitsCount(final Rank rank) {
        return result.get(rank);
    }

}
