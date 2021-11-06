package lotto.domain.result;

import lotto.domain.number.MatchedCount;
import lotto.domain.number.Payment;
import lotto.domain.ticket.LottoNumbers;
import lotto.domain.ticket.Ticket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private static final float FLOAT_NUMBER_HUNDRED = 100.f;
    private static final int RANK_COUNT_DEFAULT_VALUE = 0;
    private static final int RANK_COUNT_INCREMENT = 1;

    private final Map<Rank, Integer> result;

    private Result(List<Ticket> tickets, LottoNumbers winningNumbers) {
        result = new HashMap<>();
        Rank.ranks()
            .stream()
            .forEach(rank -> result.put(rank, RANK_COUNT_DEFAULT_VALUE));
        calculate(tickets, winningNumbers);
    }

    public static Result of(List<Ticket> tickets, LottoNumbers winningNumbers) {
        return new Result(tickets, winningNumbers);
    }

    private void calculate(List<Ticket> tickets, LottoNumbers winningNumbers) {
        tickets.stream()
            .map(e -> e.countEqualLottoNumber(winningNumbers))
            .filter(e -> e.number() >= 3)
            .forEach(this::increaseRankCount);
    }

    private void increaseRankCount(MatchedCount count) {
        Rank rank = Rank.rankByCountOfMatch(count.number());
        result.put(rank, result.get(rank) + RANK_COUNT_INCREMENT);
    }

    public float earningsRate(Payment payment) {
        long sum = result.entrySet()
            .stream()
            .mapToLong(k -> Rank.calculateTotalPrizeByGrade(k.getKey(), k.getValue()))
            .sum();

        return twoFixedPointFloat(payment, sum);
    }

    private float twoFixedPointFloat(final Payment payment, final long sum) {
        return (float) (Math.floor((sum * FLOAT_NUMBER_HUNDRED) / payment.number()) / FLOAT_NUMBER_HUNDRED);
    }

    public Map<Rank, Integer> result() {
        return result;
    }
}
